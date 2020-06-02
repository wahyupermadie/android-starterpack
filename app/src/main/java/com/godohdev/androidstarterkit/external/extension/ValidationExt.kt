package com.godohdev.androidstarterkit.external.extension

import com.godohdev.androidstarterkit.external.RegexConstants

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

fun String.isEmailValid(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPhoneNumberValid(): Boolean {
    return RegexConstants.PHONE_NUMBER_VALIDATION.matches(this)
}