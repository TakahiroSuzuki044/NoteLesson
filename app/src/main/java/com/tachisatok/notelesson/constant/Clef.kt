package com.tachisatok.notelesson.constant

import androidx.annotation.RawRes
import com.tachisatok.notelesson.R

/**
 * 記号Enum
 *
 * @property characters よみがな
 * @property imageRes 画像リソースID
 */
enum class Clef(
        val characters: Characters,
        @RawRes val imageRes: Int
) {
    /** ト音記号 */
    G_CLEF(
        Characters.G_CLEF,
        R.mipmap.g_clef
    ),
    /** ヘ音記号 */
    F_CLEF(
        Characters.F_CLEF,
        R.mipmap.f_clef
    )
}