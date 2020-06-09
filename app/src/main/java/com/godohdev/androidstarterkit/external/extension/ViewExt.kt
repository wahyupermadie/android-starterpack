package com.godohdev.androidstarterkit.external.extension

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
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

fun View.setMargins(
    leftMarginDp: Int? = null,
    topMarginDp: Int? = null,
    rightMarginDp: Int? = null,
    bottomMarginDp: Int? = null
) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val params = layoutParams as ViewGroup.MarginLayoutParams
        leftMarginDp?.run { params.leftMargin = context.dpToPx(this) }
        topMarginDp?.run { params.topMargin = context.dpToPx(this) }
        rightMarginDp?.run { params.rightMargin = context.dpToPx(this) }
        bottomMarginDp?.run { params.bottomMargin = context.dpToPx(this) }
        requestLayout()
    }
}

fun Context.dpToPx(number: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, number.toFloat(), resources.displayMetrics).toInt()
}