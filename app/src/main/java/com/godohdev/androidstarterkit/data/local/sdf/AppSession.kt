package com.godohdev.androidstarterkit.data.local.sdf

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

interface AppSession {
    fun setTokenAuth(key: String)
    fun getTokenAuth() : String
}