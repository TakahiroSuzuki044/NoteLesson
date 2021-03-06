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
     * 範囲選択画面
     */
    RECENT_GAME_RANGE(R.string.recent_game_range, R.string.recent_game_range_jp),
    RECORD(R.string.record, R.string.record_jp),
    RANGE_SELECT_TITLE(R.string.range_select_title, R.string.range_select_title_jp),

    /**
     * ゲーム中画面
     */
    GAME_PLAYING_TITLE(R.string.game_playing_title, R.string.game_playing_title_jp),

    /**
     * ゲーム結果画面
     */
    GAME_RESULT_TITLE(R.string.game_result_title, R.string.game_result_title_jp),
    GO_BACK(R.string.go_back, R.string.go_back_jp),
    REPLAY(R.string.replay, R.string.replay_jp),
    TOTAL_QUESTION_NUMBER(R.string.total_question_number, R.string.total_question_number_jp),
    CORRECT_TEXT_FOR_GAME_RESULT(R.string.correct_text_for_game_result, R.string.correct_text_for_game_result_jp),

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
    C_TO_C(R.string.c_to_c, R.string.c_to_c_jp)
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