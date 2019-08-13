package com.tachisatok.notelesson.view.game

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.tachisatok.notelesson.BR
import com.tachisatok.notelesson.constant.Scale
import com.tachisatok.notelesson.constant.ScaleRange

class GamePlayingViewModel(
    context: Context,
    gClefScaleRange: ScaleRange?,
    fClefScaleRange: ScaleRange?
): BaseObservable() {

    val gameScaleGenerator = GameScaleGenerator(gClefScaleRange, fClefScaleRange)

    var questionImageRes: Int

    @get:Bindable
    var answerCandidateScale1: Scale? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.answerCandidateScale1)
        }

    var answerCandidateScale2: Scale
    var answerCandidateScale3: Scale
    var answerCandidateScale4: Scale

    init {
        val scale = gameScaleGenerator.getScale()
        answerCandidateScale1 = scale
        answerCandidateScale2 = scale
        answerCandidateScale3 = scale
        answerCandidateScale4 = scale
        questionImageRes = scale.imageRes
    }

    /**
     * 回答
     */
    fun onClickAnswer(view: View) {
        Log.i("GamePlayingViewModel", view.tag.toString())
        val scale = gameScaleGenerator.getScale()
        answerCandidateScale1 = scale
        answerCandidateScale2 = scale
        answerCandidateScale3 = scale
        answerCandidateScale4 = scale
        questionImageRes = scale.imageRes
    }
}