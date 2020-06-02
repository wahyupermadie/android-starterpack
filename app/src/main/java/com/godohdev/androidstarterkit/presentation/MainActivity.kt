package com.godohdev.androidstarterkit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.godohdev.androidstarterkit.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }
}
