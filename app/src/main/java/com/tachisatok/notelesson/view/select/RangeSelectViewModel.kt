package com.tachisatok.notelesson.view.select

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.view.select.usecase.RangeSelectItemCreator

class RangeSelectViewModel(context: Context, gameLevel: GameLevel) : ViewModel() {

    val pleaseSelectRangeText = Characters.PLEASE_SELECT_RANGE.getString(context)
    val gClefText = Characters.G_CLEF.getString(context)
    val fClefText = Characters.F_CLEF.getString(context)
    val gClefAndFClefText = "${gClefText}と$fClefText"

    val gClefList: List<RangeSelectHorizontalItemData>
    val fClefList: List<RangeSelectHorizontalItemData>
    val gClefAndFClefList: List<RangeSelectHorizontalItemData>

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