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
    scaleRange: ScaleRange
) : BaseObservable(), GameTimer.Callback {

    private val gameScaleGenerator = GameScaleGenerator(scaleRange)

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
    var timeCountStr: String = COUNT_DOWN_TIME.toString()
        set(value) {
            field = if (value.toInt() in 0..9) {
                // ゼロ埋めする
                "0$value"
            } else {
                value
            }
            notifyPropertyChanged(BR.timeCountStr)
        }

    private val gameTimer = GameTimer(this, COUNT_DOWN_TIME)

    init {
        // 出題
        questionScale = gameScaleGenerator.getScale()
        questionImageRes.set(questionScale.imageRes)
        gameTimer.start()
    }

    override fun onTime(second: Int) {
        timeCountStr = second.toString()

        if (second <= 0) {
            gameTimer.cancel()
            gameEndCallback.onFinish(correctCount)
        }
    }

    /**
     * 回答
     */
    fun onClickAnswer(view: View) {
        if (view.tag == questionScale.noteName) {
            questionScale = gameScaleGenerator.getScale()
            questionImageRes.set(questionScale.imageRes)
            correctCount++
            correctCountStr = correctCount.toString()
            failCount.set(0)
        } else {
            failCount.set(failCount.get() + 1)
        }
    }

    interface GameEndCallback {
        /**
         * ゲームの終了時に実行される
         *
         * @param correctCount 正解回数
         */
        fun onFinish(correctCount: Int)
    }

    companion object {
        /**
         * 制限時間
         */
        private const val COUNT_DOWN_TIME = 30
    }
}