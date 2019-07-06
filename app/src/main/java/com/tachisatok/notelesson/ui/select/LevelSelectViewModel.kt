package com.tachisatok.notelesson.ui.select

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.JapaneseCharacters

class LevelSelectViewModel(context: Context) : ViewModel() {
    val pleaseSelectLevelText = JapaneseCharacters.PLEASE_SELECT_LEVEL.getString(context)
    val level1Text = JapaneseCharacters.LEVEL_1.getString(context)
    val level1ImageRes = R.mipmap.level_1
    val level2Text = JapaneseCharacters.LEVEL_2.getString(context)
    val level2ImageRes = R.mipmap.level_2
    val level3Text = JapaneseCharacters.LEVEL_3.getString(context)
    val level3ImageRes = R.mipmap.level_3
}