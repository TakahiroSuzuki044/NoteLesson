package com.tachisatok.notelesson.view.ui

import android.view.View

interface OnClickCallback {
    fun onClick(view: View, item: Any, position: Int)
}