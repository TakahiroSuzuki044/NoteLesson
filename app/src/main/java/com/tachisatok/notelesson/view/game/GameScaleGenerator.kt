package com.tachisatok.notelesson.view.game

import com.tachisatok.notelesson.constant.NoteName
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
     * 出題する選択肢を返却する
     *
     * @param target 問題の正解
     */
    fun getChoice(target: Scale): ChoiceData {
        val choiceNoteList = NoteName.values()
            .filter { it != target.noteName }
            .shuffled()

        return ChoiceData(
            Scale.of(target.clef, choiceNoteList[0]),
            Scale.of(target.clef, choiceNoteList[1]),
            Scale.of(target.clef, choiceNoteList[2])
        )
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

    /**
     * 回答の選択肢を格納するデータクラス
     */
    data class ChoiceData(
        val first: Scale,
        val second: Scale,
        val third: Scale
    )
}