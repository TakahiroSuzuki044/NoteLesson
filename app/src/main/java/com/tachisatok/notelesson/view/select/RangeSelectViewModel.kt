package com.tachisatok.notelesson.view.select

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tachisatok.notelesson.constant.Character
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.constant.GameRange
import com.tachisatok.notelesson.view.select.usecase.RangeSelectItemCreator

class RangeSelectViewModel(context: Context, gameLevel: GameLevel) : ViewModel() {

    val pleaseSelectRangeText = Character.PLEASE_SELECT_RANGE.getString(context)
    val gClefText = Character.G_CLEF.getString(context)
    val fClefText = Character.F_CLEF.getString(context)
    val gClefAndFClefText = "${gClefText}と$fClefText"
    val gClefList: List<GameRange>
    val fClefList: List<GameRange>
    val gClefAndFClefList: List<GameRange>

    init {
        val rangeSelectItemCreator = RangeSelectItemCreator(gameLevel)
        gClefList = rangeSelectItemCreator.getGClefItem()
        fClefList = rangeSelectItemCreator.getFClefItem()
        gClefAndFClefList = rangeSelectItemCreator.getGClefAndFClefItem()
    }

    class RangeSelectViewModelFactory(private val context: Context, private val gameLevel: GameLevel) :
        ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == RangeSelectViewModel::class.java) return RangeSelectViewModel(context, gameLevel) as T

            throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
        }
    }
}