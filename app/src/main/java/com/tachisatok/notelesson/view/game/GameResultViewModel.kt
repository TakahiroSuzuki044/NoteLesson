package com.tachisatok.notelesson.view.game

class GameResultViewModel(
    private val correctCount: Int
) {

    val correctCountStr: String

    init {
        correctCountStr = correctCount.toString()
    }

    fun onClickBack() {

    }

    fun onClickReplay() {

    }
}