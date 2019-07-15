package com.tachisatok.notelesson.view.select

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Character
import com.tachisatok.notelesson.constant.GameLevel

class LevelSelectViewModel(context: Context) : ViewModel() {
    val pleaseSelectLevelText = Character.PLEASE_SELECT_LEVEL.getString(context)
    val level1Text = Character.LEVEL_1.getString(context)
    val level1ImageRes = R.mipmap.level_1
    val level1GameLevel = GameLevel.LEVEL1
    val level2Text = Character.LEVEL_2.getString(context)
    val level2ImageRes = R.mipmap.level_2
    val level2GameLevel = GameLevel.LEVEL2
    val level3Text = Character.LEVEL_3.getString(context)
    val level3ImageRes = R.mipmap.level_3
    val level3GameLevel = GameLevel.LEVEL3

    class LevelSelectViewModelFactory(private val context: Context) :
        ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == LevelSelectViewModel::class.java) return LevelSelectViewModel(
                context
            ) as T

            throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
        }
    }
}