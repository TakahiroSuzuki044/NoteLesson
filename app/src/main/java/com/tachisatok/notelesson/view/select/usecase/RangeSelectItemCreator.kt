package com.tachisatok.notelesson.view.select.usecase

import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.view.select.RangeSelectHorizontalItemData

class RangeSelectItemCreator(private val gameLevel: GameLevel) {

    /**
     * G_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getGClefItem(): List<RangeSelectHorizontalItemData> {
        return when (gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_E),
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_G),
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE5_C)
                )
            }
            GameLevel.LEVEL2 -> {
                listOf(
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_E),
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_G),
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE6_C)
                )
            }
            GameLevel.LEVEL3 -> {
                listOf(
                    RangeSelectHorizontalItemData(gClefScaleRange = ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE6_C)
                )
            }
        }
    }

    /**
     * F_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getFClefItem(): List<RangeSelectHorizontalItemData> {
        return when (gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE3_A_TO_OCTAVE4_C),
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE3_F_TO_OCTAVE4_C),
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE3_C_TO_OCTAVE4_C)
                )
            }
            GameLevel.LEVEL2 -> {
                listOf(
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE2_A_TO_OCTAVE3_C),
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE2_F_TO_OCTAVE3_C),
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE3_C)
                )
            }
            GameLevel.LEVEL3 -> {
                listOf(
                    RangeSelectHorizontalItemData(fClefScaleRange = ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE4_C)
                )
            }
        }
    }

    /**
     * G_CLEFとF_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getGClefAndFClefItem(): List<RangeSelectHorizontalItemData> {
        return when (gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_E, ScaleRange.F_CLEF_OCTAVE3_A_TO_OCTAVE4_C),
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE4_G, ScaleRange.F_CLEF_OCTAVE3_F_TO_OCTAVE4_C),
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE5_C, ScaleRange.F_CLEF_OCTAVE3_C_TO_OCTAVE4_C)
                )
            }
            GameLevel.LEVEL2 -> {
                listOf(
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_E, ScaleRange.F_CLEF_OCTAVE2_A_TO_OCTAVE3_C),
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE5_G, ScaleRange.F_CLEF_OCTAVE2_F_TO_OCTAVE3_C),
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE5_C_TO_OCTAVE6_C, ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE3_C)
                )
            }
            GameLevel.LEVEL3 -> {
                listOf(
                    RangeSelectHorizontalItemData(ScaleRange.G_CLEF_OCTAVE4_C_TO_OCTAVE6_C, ScaleRange.F_CLEF_OCTAVE2_C_TO_OCTAVE4_C)
                )
            }
        }
    }
}