package com.tachisatok.notelesson.view.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageSrc")
fun imageSrc(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}