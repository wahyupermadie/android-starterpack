package com.godohdev.androidstarterkit.external.network

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.godohdev.androidstarterkit.data.Resource
import io.reactivex.Single
import org.jetbrains.anko.doAsync

/**
 *
 * Created by Wahyu Permadi on 10/06/20.
 * Android Engineer
 *
 **/

abstract class NetworkBoundResource<ResultType, RequestType>(private val schedulerProvider: SchedulerProvider) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        // Lazy disk observable.
        result.value = Resource.loading(null)
        val localData = loadFromDb()
        result.addSource(localData) {
            result.removeSource(localData)
            if (shouldFetch(it)) {
                fetchDataNetwork(localData)
            } else {
                result.addSource(localData) { value ->
                    setValue(Resource.success(value))
                }
            }
        }
    }

    private fun fetchDataNetwork(localData: LiveData<ResultType>) {
        val networkFetch = networkCall(createCall())
        result.addSource(localData) {
            setValue(Resource.loading(it))
        }

        result.addSource(networkFetch) { response ->
            result.removeSource(networkFetch)
            result.removeSource(localData)
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    doAsync {
                        response.data?.let { it1 ->
                            saveCallResult(processResponse(it1))
                        }
                    }.let {
                        result.addSource(loadFromDb()) { data ->
                            setValue(Resource.success(data))
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    result.addSource(localData) {
                        setValue(Resource.error(response.error ?: Throwable(), it))
                    }
                }
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun networkCall(createCall: Single<RequestType>): LiveData<Resource<RequestType>> {
        val response = MutableLiveData<Resource<RequestType>>()
        createCall
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe({
                response.value = Resource.success(it)
            }, {
                response.value = Resource.error(it, null)
            })
        return response
    }

    protected open fun onFetchFailed() {}

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): ResultType

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @WorkerThread
    protected abstract fun saveCallResult(request: ResultType)

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun createCall(): Single<RequestType>
}