package com.godohdev.androidstarterkit.di.module

import android.app.Application
import android.content.Context
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
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application) : Context = application
}