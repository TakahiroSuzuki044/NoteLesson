package com.tachisatok.notelesson.view.game

import com.tachisatok.notelesson.R

class GameResultViewModel(
    correctCount: Int,
    private val callback: Callback
) {

    /**
     * 正解数の文字列
     */
    val correctCountStr: String = correctCount.toString()

    /**
     * 正解数のアニメーション（グラデーション用）
     */
    val startCorrectNumberGradientAnim = R.anim.start_correct_number_gradient_anim
    
    /**
     * 正解数のアニメーション（数字用）
     */
    val startCorrectNumberAnim = R.anim.start_correct_number_anim

    fun onClickBack() {
        callback.onClickBack()
    }

    fun onClickReplay() {
        callback.onClickReplay()
    }

    interface Callback {
        /**
         * 戻るボタン（アプリレイアウトで生成しているボタン）のイベントコールバック
         */
        fun onClickBack()

        /**
         * リプレイボタンのイベントコールバック
         */
        fun onClickReplay()
    }
}