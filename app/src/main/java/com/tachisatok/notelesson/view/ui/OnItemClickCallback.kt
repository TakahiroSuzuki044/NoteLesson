package com.tachisatok.notelesson.view.ui

import android.view.View

interface OnItemClickCallback {
    fun onItemClick(view: View, item: Any, position: Int)
}