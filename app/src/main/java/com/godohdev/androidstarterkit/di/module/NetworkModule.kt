package com.godohdev.androidstarterkit.di.module

import android.content.Context
import com.godohdev.androidstarterkit.BuildConfig
import com.godohdev.androidstarterkit.data.local.sdf.AppSession
import com.godohdev.androidstarterkit.data.network.ApiService
import com.godohdev.androidstarterkit.external.network.NetworkInterceptor
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun gson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideOkHttpClient(appSession: AppSession, context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor(appSession))
            .addInterceptor(ChuckInterceptor(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideRestClient(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun apiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}