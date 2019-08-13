package com.tachisatok.notelesson.view.game

import com.tachisatok.notelesson.constant.Scale
import com.tachisatok.notelesson.constant.ScaleRange

class GameScaleGenerator(
    gClefScaleRange: ScaleRange?,
    fClefScaleRange: ScaleRange?
) {
    /**
     * 返却する音階の範囲
     */
    private val scaleList = mutableListOf<Scale>()

    /**
     * 操作用の音階の範囲
     */
    private var copyScaleList = mutableListOf<Scale>()

    /**
     * 前回返却した音階
     */
    private var beforeScale: Scale? = null

    init {
        gClefScaleRange?.let { scaleList.addAll(it.scaleList) }
        fClefScaleRange?.let { scaleList.addAll(it.scaleList) }
        copy()
    }

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
        copyScaleList = ArrayList(scaleList)
        copyScaleList.shuffle()
    }
}