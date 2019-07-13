package com.tachisatok.notelesson.constant

/**
 * ゲームレベルを管理するEnum
 *
 * @property scaleRangeList 出題する範囲
 */
enum class GameRange(
    val gameLevel: GameLevel,
    val scaleRangeList: List<ScaleRange>
) {

    // LEVEL1
    LEVEL1_G_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_E)),
    LEVEL1_G_CLEF2(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_G)),
    LEVEL1_G_CLEF3(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE5_C)),

    LEVEL1_F_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.F_CLEF_OCTAVE3_A_TO_OCTAVE4_C)),
    LEVEL1_F_CLEF2(GameLevel.LEVEL1, listOf(ScaleRange.F_CLEF_OCTAVE3_F_TO_OCTAVE4_C)),
    LEVEL1_F_CLEF3(GameLevel.LEVEL1, listOf(ScaleRange.F_CLEF_OCTAVE3_C_TO_OCTAVE4_C)),

    LEVEL1_G_AND_F_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_E, ScaleRange.F_CLEF_OCTAVE3_A_TO_OCTAVE4_C)),
    LEVEL1_G_AND_F_CLEF2(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_G, ScaleRange.F_CLEF_OCTAVE3_F_TO_OCTAVE4_C)),
    LEVEL1_G_AND_F_CLEF3(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE5_C, ScaleRange.F_CLEF_OCTAVE3_C_TO_OCTAVE4_C)),

    // LEVEL2
    LEVEL2_G_CLEF1(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_E)),
    LEVEL2_G_CLEF2(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_G)),
    LEVEL2_G_CLEF3(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE6_C)),

    LEVEL2_F_CLEF1(GameLevel.LEVEL2, listOf(ScaleRange.F_CLEF_OCTAVE2_A_TO_OCTAVE3_C)),
    LEVEL2_F_CLEF2(GameLevel.LEVEL2, listOf(ScaleRange.F_CLEF_OCTAVE2_F_TO_OCTAVE3_C)),
    LEVEL2_F_CLEF3(GameLevel.LEVEL2, listOf(ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE3_C)),

    LEVEL2_G_AND_F_CLEF1(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_E, ScaleRange.F_CLEF_OCTAVE2_A_TO_OCTAVE3_C)),
    LEVEL2_G_AND_F_CLEF2(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_G, ScaleRange.F_CLEF_OCTAVE2_F_TO_OCTAVE3_C)),
    LEVEL2_G_AND_F_CLEF3(GameLevel.LEVEL2, listOf(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE6_C, ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE3_C)),

    // LEVEL3
    LEVEL3_G_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE6_C)),
    LEVEL3_F_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE4_C)),
    LEVEL3_G_AND_F_CLEF1(GameLevel.LEVEL1, listOf(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE6_C, ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE4_C)),
}