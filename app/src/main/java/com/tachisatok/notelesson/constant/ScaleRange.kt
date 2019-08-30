package com.tachisatok.notelesson.constant

import com.tachisatok.notelesson.R

/**
 * 出題する音階の範囲を管理するEnum
 *
 * @property characters よみがな
 * @property scaleList 音階リスト
 */
enum class ScaleRange(
    val clef: Clef,
    val imageRes: Int,
    val characters: Characters,
    val scaleList: List<Scale>
) {
    // G_CLEF
    G_CLEF_OCTAVE4_C_TO_OCTAVE4_E(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave4_c_e,
        Characters.C_TO_E,
        listOf(
            Scale.G_CLEF_OCTAVE4_C,
            Scale.G_CLEF_OCTAVE4_D,
            Scale.G_CLEF_OCTAVE4_E
        )
    ),
    G_CLEF_OCTAVE4_C_TO_OCTAVE4_G(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave4_c_g,
        Characters.C_TO_G,
        listOf(
            Scale.G_CLEF_OCTAVE4_C,
            Scale.G_CLEF_OCTAVE4_D,
            Scale.G_CLEF_OCTAVE4_E,
            Scale.G_CLEF_OCTAVE4_F,
            Scale.G_CLEF_OCTAVE4_G
        )
    ),
    G_CLEF_OCTAVE4_C_TO_OCTAVE5_C(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave4_c_c,
        Characters.C_TO_C,
        listOf(
            Scale.G_CLEF_OCTAVE4_C,
            Scale.G_CLEF_OCTAVE4_D,
            Scale.G_CLEF_OCTAVE4_E,
            Scale.G_CLEF_OCTAVE4_F,
            Scale.G_CLEF_OCTAVE4_G,
            Scale.G_CLEF_OCTAVE4_A,
            Scale.G_CLEF_OCTAVE4_B,
            Scale.G_CLEF_OCTAVE5_C
        )
    ),
    G_CLEF_OCTAVE5_C_TO_OCTAVE5_E(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave5_c_e,
        Characters.C_TO_E,
        listOf(
            Scale.G_CLEF_OCTAVE5_C,
            Scale.G_CLEF_OCTAVE5_D,
            Scale.G_CLEF_OCTAVE5_E
        )
    ),
    G_CLEF_OCTAVE5_C_TO_OCTAVE5_G(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave5_c_g,
        Characters.C_TO_G,
        listOf(
            Scale.G_CLEF_OCTAVE5_C,
            Scale.G_CLEF_OCTAVE5_D,
            Scale.G_CLEF_OCTAVE5_E,
            Scale.G_CLEF_OCTAVE5_F,
            Scale.G_CLEF_OCTAVE5_G
        )
    ),
    G_CLEF_OCTAVE5_C_TO_OCTAVE6_C(
        Clef.G_CLEF,
        R.mipmap.g_clef_octave5_c_c,
        Characters.C_TO_C,
        listOf(
            Scale.G_CLEF_OCTAVE5_C,
            Scale.G_CLEF_OCTAVE5_D,
            Scale.G_CLEF_OCTAVE5_E,
            Scale.G_CLEF_OCTAVE5_F,
            Scale.G_CLEF_OCTAVE5_G,
            Scale.G_CLEF_OCTAVE5_A,
            Scale.G_CLEF_OCTAVE5_B,
            Scale.G_CLEF_OCTAVE6_C
        )
    ),

    // F_CLEF
    F_CLEF_OCTAVE2_C_TO_OCTAVE2_E(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave2_c_e,
        Characters.C_TO_E,
        listOf(
            Scale.F_CLEF_OCTAVE2_C,
            Scale.F_CLEF_OCTAVE2_D,
            Scale.F_CLEF_OCTAVE2_E
        )
    ),
    F_CLEF_OCTAVE2_C_TO_OCTAVE2_G(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave2_c_g,
        Characters.C_TO_G,
        listOf(
            Scale.F_CLEF_OCTAVE2_C,
            Scale.F_CLEF_OCTAVE2_D,
            Scale.F_CLEF_OCTAVE2_E,
            Scale.F_CLEF_OCTAVE2_F,
            Scale.F_CLEF_OCTAVE2_G
        )
    ),
    F_CLEF_OCTAVE2_C_TO_OCTAVE3_C(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave2_c_c,
        Characters.C_TO_C,
        listOf(
            Scale.F_CLEF_OCTAVE2_C,
            Scale.F_CLEF_OCTAVE2_D,
            Scale.F_CLEF_OCTAVE2_E,
            Scale.F_CLEF_OCTAVE2_F,
            Scale.F_CLEF_OCTAVE2_G,
            Scale.F_CLEF_OCTAVE2_A,
            Scale.F_CLEF_OCTAVE2_B,
            Scale.F_CLEF_OCTAVE3_C
        )
    ),

    F_CLEF_OCTAVE3_C_TO_OCTAVE3_E(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave3_c_e,
        Characters.C_TO_E,
        listOf(
            Scale.F_CLEF_OCTAVE3_C,
            Scale.F_CLEF_OCTAVE3_D,
            Scale.F_CLEF_OCTAVE3_E
        )
    ),
    F_CLEF_OCTAVE3_C_TO_OCTAVE3_G(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave3_c_g,
        Characters.C_TO_G,
        listOf(
            Scale.F_CLEF_OCTAVE3_C,
            Scale.F_CLEF_OCTAVE3_D,
            Scale.F_CLEF_OCTAVE3_E,
            Scale.F_CLEF_OCTAVE3_F,
            Scale.F_CLEF_OCTAVE3_G
        )
    ),
    F_CLEF_OCTAVE3_C_TO_OCTAVE4_C(
        Clef.F_CLEF,
        R.mipmap.f_clef_octave3_c_c,
        Characters.C_TO_C,
        listOf(
            Scale.F_CLEF_OCTAVE3_C,
            Scale.F_CLEF_OCTAVE3_D,
            Scale.F_CLEF_OCTAVE3_E,
            Scale.F_CLEF_OCTAVE3_F,
            Scale.F_CLEF_OCTAVE3_G,
            Scale.F_CLEF_OCTAVE3_A,
            Scale.F_CLEF_OCTAVE3_B,
            Scale.F_CLEF_OCTAVE4_C
        )
    );

    companion object {
        @JvmStatic
        fun of(clef: Clef): List<ScaleRange> {
            return values().filter { it.clef == clef }
        }
    }
}