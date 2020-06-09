package com.godohdev.androidstarterkit.external.network

import io.reactivex.Scheduler

/**
 *
 * Created by Wahyu Permadi on 10/06/20.
 * Android Engineer
 *
 **/

interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
}