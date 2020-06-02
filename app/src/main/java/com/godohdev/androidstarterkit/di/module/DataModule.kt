package com.godohdev.androidstarterkit.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.godohdev.androidstarterkit.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

@Module
class DataModule {
    @Provides
    @Singleton
    internal fun provideSharedPreference(application: Application) : SharedPreferences {
        return  application.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

}