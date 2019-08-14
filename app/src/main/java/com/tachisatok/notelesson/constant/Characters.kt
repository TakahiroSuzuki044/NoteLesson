package com.tachisatok.notelesson.constant

import android.content.Context
import androidx.annotation.StringRes
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.util.PreferenceUtil

/**
 * 漢字とひらがなを管理するEnum
 *
 * @property chinese 漢字読み
 * @property japanese ひらがな読み
 */
enum class Characters(
    @StringRes val chinese: Int,
    @StringRes val japanese: Int
) {
    /**
     * レベル選択画面
     */
    PLEASE_SELECT_LEVEL(R.string.please_select_level, R.string.please_select_level_jp),
    LEVEL_1(R.string.level_1, R.string.level_1_jp),
    LEVEL_2(R.string.level_2, R.string.level_2_jp),
    LEVEL_3(R.string.level_3, R.string.level_3_jp),

    /**
     * 範囲選択画面
     */
    PLEASE_SELECT_RANGE(R.string.please_select_range, R.string.please_select_range_jp),

    /**
     * ゲーム中画面
     */
    REMAINING_TIME_LABEL(R.string.remaining_time_label, R.string.remaining_time_label_jp),
    CORRECT_ANSWER_NUMBER(R.string.correct_answer_number, R.string.correct_answer_number_jp),

    /** ド */
    C(R.string.c, R.string.c_jp),
    /** レ */
    D(R.string.d, R.string.d_jp),
    /** ミ */
    E(R.string.e, R.string.e_jp),
    /** ファ */
    F(R.string.f, R.string.f_jp),
    /** ソ */
    G(R.string.g, R.string.g_jp),
    /** ラ */
    A(R.string.a, R.string.a_jp),
    /** シ */
    B(R.string.b, R.string.b_jp),
    /** ト音記号 */
    G_CLEF(R.string.g_clef, R.string.g_clef_jp),
    /** ヘ音記号 */
    F_CLEF(R.string.f_clef, R.string.f_clef_jp),
    /** ド〜ミ */
    C_TO_E(R.string.c_to_e, R.string.c_to_e_jp),
    /** ド〜ソ */
    C_TO_G(R.string.c_to_g, R.string.c_to_g_jp),
    /** ド〜ド */
    C_TO_C(R.string.c_to_c, R.string.c_to_c_jp),
    /** ラ〜ド */
    A_TO_C(R.string.a_to_c, R.string.a_to_c_jp),
    /** ファ〜ド */
    F_TO_C(R.string.f_to_c, R.string.f_to_c_jp),
    ;

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