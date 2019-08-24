package com.tachisatok.notelesson.view.game

class GameResultViewModel(
    correctCount: Int,
    private val callback: Callback
) {

    /**
     * 正解数の文字列
     */
    val correctCountStr: String = correctCount.toString()

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