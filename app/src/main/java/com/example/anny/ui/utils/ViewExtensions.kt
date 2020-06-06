package com.example.anny.ui.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.Group



fun View?.hideSoftInput() {
    (this?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?)
        ?.hideSoftInputFromWindow(this?.windowToken, 0)
}

fun View?.showSoftInput() {
    (this?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?)
        ?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * prevent multiple click/tap
 * #ref : https://medium.com/@simonkarmy2004/solving-android-multiple-clicks-problem-kotlin-b99c06135da0
 */
fun View.setOnSafeClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun Group.setAllOnClickListener(listener: (View) -> Unit) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}

fun View.hideView() {
    this.visibility = View.GONE
}

fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}