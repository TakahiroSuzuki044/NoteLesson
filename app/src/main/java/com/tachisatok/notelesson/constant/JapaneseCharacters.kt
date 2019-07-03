package com.tachisatok.notelesson.constant

import android.content.Context
import androidx.annotation.StringRes
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.ui.util.PreferenceUtil

enum class JapaneseCharacters(
    @StringRes val chinese: Int,
    @StringRes val japanese: Int
) {
    PLEASE_SELECT_LEVEL(R.string.please_select_level, R.string.please_select_level_h),
    LEVEL_1(R.string.level_1, R.string.level_1_h),
    LEVEL_2(R.string.level_2, R.string.level_2_h),
    LEVEL_3(R.string.level_3, R.string.level_3_h);

    /**
     * 文字列を返却する
     */
    fun getString(context: Context): String {
        val characterDisplay =
            PreferenceUtil.getString(context, KEY_CHARACTER_TO_DISPLAY)?.let {
                CharacterDisplay.valueOf(it)
            } ?: CharacterDisplay.CHINESE_CHARACTERS

        return if (characterDisplay == CharacterDisplay.CHINESE_CHARACTERS) {
            context.resources.getString(chinese)
        } else {
            context.resources.getString(japanese)
        }
    }
}