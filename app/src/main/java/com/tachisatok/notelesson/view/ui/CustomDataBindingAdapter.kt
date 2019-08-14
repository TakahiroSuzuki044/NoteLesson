package com.tachisatok.notelesson.view.ui

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.tachisatok.notelesson.R

@BindingAdapter("imageSrc")
fun imageSrc(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}

@BindingAdapter("startFailAnim")
fun startFailAnim(view: View, failCount: Int) {
    if (failCount == 0) return
    val anim = SpringAnimation(view, DynamicAnimation.TRANSLATION_X, 0f).setStartValue(35f)
    anim.spring.apply {
        dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        stiffness = SpringForce.STIFFNESS_MEDIUM
    }
    anim.start()
}

@BindingAdapter("startCorrectAnim")
fun startCorrectAnim(view: View, correctCount: Int) {
    if (correctCount == 0) return
    val anim = AnimationUtils.loadAnimation(view.context, R.anim.correct_anim)
    view.startAnimation(anim)
    view.visibility = View.VISIBLE
}