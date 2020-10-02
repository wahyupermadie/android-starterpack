package com.godohdev.androidstarterkit.presentation.base

import android.os.Bundle
import com.godohdev.androidstarterkit.data.ErrorHandler
import com.godohdev.androidstarterkit.data.ErrorHandler.ErrorType.SNACKBAR
import com.godohdev.androidstarterkit.external.Event
import com.godohdev.androidstarterkit.external.extension.observe
import com.godohdev.androidstarterkit.external.extension.showSnackbar
import com.google.android.material.snackbar.Snackbar

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

abstract class BaseActivityVM<T> : BaseActivity() {

    abstract fun getViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObserver(getViewModel() as BaseViewModel)
    }

    private fun setupObserver(baseViewModel: BaseViewModel) {
        observe(baseViewModel.loadingHandler, ::observeLoadingState)
        observe(baseViewModel.errorHandler, ::observeErrorState)
    }

    private fun observeErrorState(event: Event<ErrorHandler>) {
        event.getContentIfNotHandled()?.let {
            when (it.errorType) {
                SNACKBAR -> {
                    showSnackbar(
                        it.message ?: "Terjadi kesalahan pada koneksi anda",
                        Snackbar.LENGTH_LONG
                    )
                }
                else -> {
                    // Soon
                }
            }
        }
    }

    private fun observeLoadingState(loading: Event<Boolean>) {
        loading.getContentIfNotHandled()?.let {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
    }

    protected open fun showLoading() {}
    protected open fun hideLoading() {}
}
