package com.tachisatok.notelesson.constant

import androidx.annotation.RawRes
import com.tachisatok.notelesson.R

/**
 * 音階を表すEnum
 *
 * @property clef 記号
 * @property octave オクターブ
 * @property noteName 音名
 * @property imageRes 画像リソース
 */
enum class Scale(
    val clef: Clef,
    val octave: Octave,
    val noteName: NoteName,
    @RawRes val imageRes: Int
) {
    // F_CLEF
    F_CLEF_OCTAVE2_C(Clef.F_CLEF, Octave.TWO, NoteName.C, R.mipmap.f_clef_octave2_c),
    F_CLEF_OCTAVE2_D(Clef.F_CLEF, Octave.TWO, NoteName.D, R.mipmap.f_clef_octave2_d),
    F_CLEF_OCTAVE2_E(Clef.F_CLEF, Octave.TWO, NoteName.E, R.mipmap.f_clef_octave2_e),
    F_CLEF_OCTAVE2_F(Clef.F_CLEF, Octave.TWO, NoteName.F, R.mipmap.f_clef_octave2_f),
    F_CLEF_OCTAVE2_G(Clef.F_CLEF, Octave.TWO, NoteName.G, R.mipmap.f_clef_octave2_g),
    F_CLEF_OCTAVE2_A(Clef.F_CLEF, Octave.TWO, NoteName.A, R.mipmap.f_clef_octave2_a),
    F_CLEF_OCTAVE2_B(Clef.F_CLEF, Octave.TWO, NoteName.B, R.mipmap.f_clef_octave2_b),
    F_CLEF_OCTAVE3_C(Clef.F_CLEF, Octave.THREE, NoteName.C, R.mipmap.f_clef_octave3_c),
    F_CLEF_OCTAVE3_D(Clef.F_CLEF, Octave.THREE, NoteName.D, R.mipmap.f_clef_octave3_d),
    F_CLEF_OCTAVE3_E(Clef.F_CLEF, Octave.THREE, NoteName.E, R.mipmap.f_clef_octave3_e),
    F_CLEF_OCTAVE3_F(Clef.F_CLEF, Octave.THREE, NoteName.F, R.mipmap.f_clef_octave3_f),
    F_CLEF_OCTAVE3_G(Clef.F_CLEF, Octave.THREE, NoteName.G, R.mipmap.f_clef_octave3_g),
    F_CLEF_OCTAVE3_A(Clef.F_CLEF, Octave.THREE, NoteName.A, R.mipmap.f_clef_octave3_a),
    F_CLEF_OCTAVE3_B(Clef.F_CLEF, Octave.THREE, NoteName.B, R.mipmap.f_clef_octave3_b),
    F_CLEF_OCTAVE4_C(Clef.F_CLEF, Octave.FOUR, NoteName.C, R.mipmap.f_clef_octave4_c),

    // G_CLEF
    G_CLEF_OCTAVE4_C(Clef.G_CLEF, Octave.FOUR, NoteName.C, R.mipmap.g_clef_octave4_c),
    G_CLEF_OCTAVE4_D(Clef.G_CLEF, Octave.FOUR, NoteName.D, R.mipmap.g_clef_octave4_d),
    G_CLEF_OCTAVE4_E(Clef.G_CLEF, Octave.FOUR, NoteName.E, R.mipmap.g_clef_octave4_e),
    G_CLEF_OCTAVE4_F(Clef.G_CLEF, Octave.FOUR, NoteName.F, R.mipmap.g_clef_octave4_f),
    G_CLEF_OCTAVE4_G(Clef.G_CLEF, Octave.FOUR, NoteName.G, R.mipmap.g_clef_octave4_g),
    G_CLEF_OCTAVE4_A(Clef.G_CLEF, Octave.FOUR, NoteName.A, R.mipmap.g_clef_octave4_a),
    G_CLEF_OCTAVE4_B(Clef.G_CLEF, Octave.FOUR, NoteName.B, R.mipmap.g_clef_octave4_b),
    G_CLEF_OCTAVE5_C(Clef.G_CLEF, Octave.FIVE, NoteName.C, R.mipmap.g_clef_octave5_c),
    G_CLEF_OCTAVE5_D(Clef.G_CLEF, Octave.FIVE, NoteName.D, R.mipmap.g_clef_octave5_d),
    G_CLEF_OCTAVE5_E(Clef.G_CLEF, Octave.FIVE, NoteName.E, R.mipmap.g_clef_octave5_e),
    G_CLEF_OCTAVE5_F(Clef.G_CLEF, Octave.FIVE, NoteName.F, R.mipmap.g_clef_octave5_f),
    G_CLEF_OCTAVE5_G(Clef.G_CLEF, Octave.FIVE, NoteName.G, R.mipmap.g_clef_octave5_g),
    G_CLEF_OCTAVE5_A(Clef.G_CLEF, Octave.FIVE, NoteName.A, R.mipmap.g_clef_octave5_a),
    G_CLEF_OCTAVE5_B(Clef.G_CLEF, Octave.FIVE, NoteName.B, R.mipmap.g_clef_octave5_b),
    G_CLEF_OCTAVE6_C(Clef.G_CLEF, Octave.SIX, NoteName.C, R.mipmap.g_clef_octave6_c),
}