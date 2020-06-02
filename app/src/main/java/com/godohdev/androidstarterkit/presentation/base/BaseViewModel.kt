package com.godohdev.androidstarterkit.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.godohdev.androidstarterkit.data.ErrorHandler
import com.godohdev.androidstarterkit.external.Event

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

abstract class BaseViewModel : ViewModel() {

    protected val _errorHandler = MutableLiveData<Event<ErrorHandler>>()
    val errorHandler: LiveData<Event<ErrorHandler>> get() = _errorHandler

    protected val _loadingHandler = MutableLiveData<Event<Boolean>>()
    val loadingHandler: LiveData<Event<Boolean>> get() = _loadingHandler
}