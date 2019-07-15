package com.tachisatok.notelesson.view.select.usecase

import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.constant.GameRange

class RangeSelectItemCreator(private val gameLevel: GameLevel) {

    /**
     * G_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getGClefItem(): List<GameRange> {
        return when(gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(GameRange.LEVEL1_G_CLEF1, GameRange.LEVEL1_G_CLEF2, GameRange.LEVEL1_G_CLEF3)
            }
            GameLevel.LEVEL2 -> {
                listOf(GameRange.LEVEL2_G_CLEF1, GameRange.LEVEL2_G_CLEF2, GameRange.LEVEL2_G_CLEF3)
            }
            GameLevel.LEVEL3 -> {
                listOf(GameRange.LEVEL3_G_CLEF1)
            }
        }
    }

    /**
     * F_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getFClefItem(): List<GameRange> {
        return when(gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(GameRange.LEVEL1_F_CLEF1, GameRange.LEVEL1_F_CLEF2, GameRange.LEVEL1_F_CLEF3)
            }
            GameLevel.LEVEL2 -> {
                listOf(GameRange.LEVEL2_F_CLEF1, GameRange.LEVEL2_F_CLEF2, GameRange.LEVEL2_F_CLEF3)
            }
            GameLevel.LEVEL3 -> {
                listOf(GameRange.LEVEL3_F_CLEF1)
            }
        }
    }

    /**
     * G_CLEFとF_CLEFエリアに表示するリストアイテムを返却する
     *
     * @return リストアイテム
     */
    fun getGClefAndFClefItem(): List<GameRange> {
        return when(gameLevel) {
            GameLevel.LEVEL1 -> {
                listOf(GameRange.LEVEL1_G_AND_F_CLEF1, GameRange.LEVEL1_G_AND_F_CLEF2, GameRange.LEVEL1_G_AND_F_CLEF3)
            }
            GameLevel.LEVEL2 -> {
                listOf(GameRange.LEVEL2_G_AND_F_CLEF1, GameRange.LEVEL2_G_AND_F_CLEF2, GameRange.LEVEL2_G_AND_F_CLEF3)
            }
            GameLevel.LEVEL3 -> {
                listOf(GameRange.LEVEL3_G_AND_F_CLEF1)
            }
        }
    }
}