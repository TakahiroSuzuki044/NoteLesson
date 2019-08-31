package com.tachisatok.notelesson.view.game

import com.tachisatok.notelesson.constant.Scale
import com.tachisatok.notelesson.constant.ScaleRange

class GameScaleGenerator(
    private val scaleRange: ScaleRange
) {
    /**
     * 操作用の音階の範囲
     */
    private var copyScaleList = mutableListOf<Scale>()

    /**
     * 前回返却した音階
     */
    private var beforeScale: Scale? = null

    init {
        copy()
    }

    /**
     * 次の出題する[Scale]を返却する
     */
    fun getScale(): Scale {
        val targetScale = getCopyScale()
        return if (beforeScale == null) {
            beforeScale = targetScale
            targetScale
        } else {
            // 前回表示した音階と異なる音階を表示する
            if (beforeScale != targetScale) {
                beforeScale = targetScale
                targetScale
            } else {
                getCopyScale()
            }
        }
    }

    /**
     * 操作用の音階を返却する
     */
    private fun getCopyScale(): Scale {
        if (copyScaleList.isEmpty()) {
            copy()
        }

        val targetScale = copyScaleList.first()
        copyScaleList.removeAt(0)
        return targetScale
    }

    /**
     * 操作用の音階にコピーする
     */
    private fun copy() {
        copyScaleList = ArrayList(scaleRange.scaleList)
        copyScaleList.shuffle()
    }

    /**
     * 回答の選択肢を格納するデータクラス
     */
    data class ChoiceData(
        val first: Scale,
        val second: Scale,
        val third: Scale
    )
}