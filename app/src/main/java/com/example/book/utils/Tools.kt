package com.example.book.utils

import android.view.View

class Tools {
    companion object{

fun toggleArrow(show: Boolean, view: View): Boolean{
 return toggleArrow(show, view, true)
}

fun toggleArrow(show: Boolean, view: View, delay: Boolean): Boolean{
    return if (show) {
        view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(180f)
        true
    } else {
        view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(0f)
        false
    }
}
    }
}