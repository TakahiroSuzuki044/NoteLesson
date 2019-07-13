package com.tachisatok.notelesson.ui.select

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Character

class LevelSelectViewModel(context: Context) : ViewModel() {
    val pleaseSelectLevelText = Character.PLEASE_SELECT_LEVEL.getString(context)
    val level1Text = Character.LEVEL_1.getString(context)
    val level1ImageRes = R.mipmap.level_1
    val level2Text = Character.LEVEL_2.getString(context)
    val level2ImageRes = R.mipmap.level_2
    val level3Text = Character.LEVEL_3.getString(context)
    val level3ImageRes = R.mipmap.level_3
}