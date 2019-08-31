package com.tachisatok.notelesson.view.ui

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
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
fun startCorrectAnim(view: View, correctCountStr: String) {
    val correctCount = correctCountStr.toIntOrNull() ?: return
    if (correctCount == 0) return

    val anim = AnimationUtils.loadAnimation(view.context, R.anim.correct_anim)
    view.startAnimation(anim)
    view.visibility = View.VISIBLE
}

@BindingAdapter("startAnim")
fun startAnim(view: View, animRes: Int) {
    val anim = AnimationUtils.loadAnimation(view.context, animRes)
    view.startAnimation(anim)
    view.visibility = View.VISIBLE
}

@BindingAdapter("timerTextWithAnim")
fun timerTextWithAnim(view: TextView, text: String) {
    val anim = AnimationUtils.loadAnimation(view.context, R.anim.timer_text_count_anim)
    view.text = text
    val count = text.toIntOrNull()
    count?.let {
        if (count in 0..9) {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.red))
        }
    }
    view.startAnimation(anim)
    view.visibility = View.VISIBLE
}

@BindingAdapter("timerText")
fun timerText(view: TextView, text: String) {
    view.text = text
    val count = text.toIntOrNull()
    count?.let {
        if (count in 0..10) {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.red))
        }
    }
    view.visibility = View.VISIBLE
}

@BindingAdapter("timerSrc")
fun timerSrc(view: ImageView, countStr: String) {
    val count = countStr.toIntOrNull()

    if (count != null && count in 0..10) {
        val fromAnim = AnimationUtils.loadAnimation(view.context, R.anim.timer_image_from_anim)
        fromAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                // ignore
            }

            override fun onAnimationEnd(animation: Animation?) {
                val toAnim = AnimationUtils.loadAnimation(view.context, R.anim.timer_image_to_anim)
                view.startAnimation(toAnim)
            }

            override fun onAnimationStart(animation: Animation?) {
                // ignore
            }
        })
        view.startAnimation(fromAnim)
        view.setImageResource(R.mipmap.red_timer)
    } else {
        view.setImageResource(R.mipmap.timer)
    }
    view.visibility = View.VISIBLE
}

@BindingAdapter("correctTextWithAnim")
fun correctTextWithAnim(view: TextView, text: String) {
    val anim = AnimationUtils.loadAnimation(view.context, R.anim.correct_text_count_anim)
    view.text = text
    view.startAnimation(anim)
    view.visibility = View.VISIBLE
}
