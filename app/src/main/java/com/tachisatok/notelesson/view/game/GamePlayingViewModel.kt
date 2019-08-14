package com.tachisatok.notelesson.view.game

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableInt
import com.tachisatok.notelesson.BR
import com.tachisatok.notelesson.constant.Scale
import com.tachisatok.notelesson.constant.ScaleRange

class GamePlayingViewModel(
    val context: Context,
    gClefScaleRange: ScaleRange?,
    fClefScaleRange: ScaleRange?
): BaseObservable() {
    
    private val gameScaleGenerator = GameScaleGenerator(gClefScaleRange, fClefScaleRange)

    var questionImageRes = ObservableInt()

    var questionScale: Scale

    @get:Bindable
    var answerChoiceScale1: Scale? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.answerChoiceScale1)
        }

    @get:Bindable
    var answerChoiceScale2: Scale? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.answerChoiceScale2)
        }

    @get:Bindable
    var answerChoiceScale3: Scale? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.answerChoiceScale3)
        }

    @get:Bindable
    var answerChoiceScale4: Scale? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.answerChoiceScale4)
        }

    init {
        // 出題
        questionScale = gameScaleGenerator.getScale()
        setChoice(questionScale)
        questionImageRes.set(questionScale.imageRes)
    }

    /**
     * 回答
     */
    fun onClickAnswer(view: View) {
        if (view.tag == questionScale) {
            questionScale = gameScaleGenerator.getScale()
            setChoice(questionScale)
            questionImageRes.set(questionScale.imageRes)
            Toast.makeText(context, "正解！", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "間違い！", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 選択肢を設定する
     *
     * @param questionScale 出題の正解
     */
    private fun setChoice(questionScale: Scale) {
        val choiceData = gameScaleGenerator.getChoice(questionScale)
        val choiceList =
            mutableListOf(
                questionScale,
                choiceData.first,
                choiceData.second,
                choiceData.third)
            .shuffled()

        answerChoiceScale1 = choiceList[0]
        answerChoiceScale2 = choiceList[1]
        answerChoiceScale3 = choiceList[2]
        answerChoiceScale4 = choiceList[3]
    }
}