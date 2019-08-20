package com.tachisatok.notelesson.view.game

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableInt
import com.tachisatok.notelesson.BR
import com.tachisatok.notelesson.constant.Scale
import com.tachisatok.notelesson.constant.ScaleRange

class GamePlayingViewModel(
    val context: Context,
    private val gameEndCallback: GameEndCallback,
    gClefScaleRange: ScaleRange?,
    fClefScaleRange: ScaleRange?
) : BaseObservable(), GameTimer.Callback {

    private val gameScaleGenerator = GameScaleGenerator(gClefScaleRange, fClefScaleRange)

    /**
     * 出題の画像
     */
    var questionImageRes = ObservableInt()

    /**
     * 出題の[Scale]
     */
    private var questionScale: Scale

    /**
     * 不正解回数
     */
    var failCount = ObservableInt(0)

    /**
     * 正解回数
     */
    var correctCount = 0

    /**
     * 正解回数の文字列（Viewへの表示用）
     */
    @get:Bindable
    var correctCountStr: String = "0"
        set(value) {
            field = value
            notifyPropertyChanged(BR.correctCountStr)
        }

    @get:Bindable
    var timeCountStr: String = "0"
        set(value) {
            field = value
            notifyPropertyChanged(BR.timeCountStr)
        }

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

    private val gameTimer = GameTimer(this)

    init {
        // 出題
        questionScale = gameScaleGenerator.getScale()
        setChoice(questionScale)
        questionImageRes.set(questionScale.imageRes)
        gameTimer.start()
    }

    override fun onTime(second: Int) {
        timeCountStr = second.toString()

        if (second >= 30) {
            gameTimer.cancel()
            gameEndCallback.onFinish(correctCount)
        }
    }

    /**
     * 回答
     */
    fun onClickAnswer(view: View) {
        if (view.tag == questionScale) {
            questionScale = gameScaleGenerator.getScale()
            setChoice(questionScale)
            questionImageRes.set(questionScale.imageRes)
            correctCount++
            correctCountStr = correctCount.toString()
            failCount.set(0)
        } else {
            failCount.set(failCount.get() + 1)
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
                choiceData.third
            )
                .shuffled()

        answerChoiceScale1 = choiceList[0]
        answerChoiceScale2 = choiceList[1]
        answerChoiceScale3 = choiceList[2]
        answerChoiceScale4 = choiceList[3]
    }

    interface GameEndCallback {
        /**
         * ゲームの終了時に実行される
         *
         * @param correctCount 正解回数
         */
        fun onFinish(correctCount: Int)
    }
}