package com.godohdev.androidstarterkit.external.network

import com.godohdev.androidstarterkit.data.local.sdf.AppSession
import okhttp3.Interceptor
import okhttp3.Response

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

class NetworkInterceptor(private val appSession: AppSession) : Interceptor {
    private val token: String?
        get() = appSession.getTokenAuth()

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        token?.let {
            request = if (it.isNotEmpty()) {
                val finalToken = "Bearer $token"
                val lOriginalRequest = chain.request()
                val lRequest = lOriginalRequest.newBuilder()
                    .header("Authorization", finalToken)
                    .method(lOriginalRequest.method, lOriginalRequest.body).build()
                lRequest
            } else {
                val lOriginalRequest = chain.request()
                val lRequest = lOriginalRequest.newBuilder()
                    .method(lOriginalRequest.method, lOriginalRequest.body).build()
                lRequest
            }
        }
        return chain.proceed(request)
    }
}