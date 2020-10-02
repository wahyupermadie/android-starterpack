package com.godohdev.androidstarterkit.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Franz Andel on 02/10/20.
 * Android Engineer
 */

abstract class BaseActivity: AppCompatActivity() {

    abstract fun onLoadView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLoadView(savedInstanceState)
    }
}