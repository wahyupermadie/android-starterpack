package com.godohdev.androidstarterkit.data.local.sdf

import android.content.SharedPreferences
import androidx.core.content.edit
import com.godohdev.androidstarterkit.external.AppSessionConstants.AUTH_TOKEN
import javax.inject.Inject

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

class AppSessionImpl(
    private val sharedPreferences: SharedPreferences
) : AppSession {

    override fun setTokenAuth(key: String){
        sharedPreferences.edit(commit = true){
            putString(AUTH_TOKEN, key)
        }
    }

    override fun getTokenAuth() : String {
        return sharedPreferences.getString(AUTH_TOKEN, "")!!
    }
}