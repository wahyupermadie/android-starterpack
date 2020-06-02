package com.godohdev.androidstarterkit.external

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

object AppSessionConstants {
    const val AUTH_TOKEN = "auth_token"
}

object RegexConstants {
    val PHONE_NUMBER_VALIDATION = "(\\()?(\\+62|62|08)(\\d{2,3})?\\)?[ .-]?\\d{1}[ .-]?\\d{1,2}[ .-]?\\d{4,6}".toRegex()
}