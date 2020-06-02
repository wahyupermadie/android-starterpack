package com.godohdev.androidstarterkit.data

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

data class ErrorHandler(
    val message: String?,
    val errorType: ErrorType
) {
    enum class ErrorType {
        SNACKBAR,
        DIALOG
    }
}