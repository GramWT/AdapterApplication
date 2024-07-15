package com.example.adapterapplication

import android.view.View

object TextUtils {

    fun View.visible() {
        this.visibility = View.VISIBLE
    }

    fun View.invisible() {
        this.visibility = View.INVISIBLE
    }

    fun View.gone(){
        this.visibility = View.GONE
    }
}