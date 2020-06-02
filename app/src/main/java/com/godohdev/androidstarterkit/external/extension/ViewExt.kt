package com.godohdev.androidstarterkit.external.extension

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 *
 * Created by Wahyu Permadi on 02/06/20.
 * Android Engineer
 *
 **/

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById(android.R.id.content), snackbarText, timeLength).show() }
}

fun Activity.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this.findViewById(android.R.id.content), snackbarText, timeLength).show()
}