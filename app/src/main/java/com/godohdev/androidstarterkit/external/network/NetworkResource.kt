package com.godohdev.androidstarterkit.external.network

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.godohdev.androidstarterkit.data.Resource
import io.reactivex.Single

/**
 *
 * Created by Wahyu Permadi on 10/06/20.
 * Android Engineer
 *
 **/

abstract class NetworkResource<ResultType, RequestType>(private val appSchedulerProvider: SchedulerProvider) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        setValue(Resource.loading(null))
        fetchNetwork()
    }

    @SuppressLint("CheckResult")
    private fun fetchNetwork() {
        createCall().apply {
            this.observeOn(appSchedulerProvider.ui())
                .subscribeOn(appSchedulerProvider.io())
                .subscribe({
                    setValue(Resource.success(processResponse(it)))
                }, {
                    setValue(Resource.error(it ?: Throwable(), null))
                })
        }
    }

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
    protected abstract fun createCall(): Single<RequestType>
}