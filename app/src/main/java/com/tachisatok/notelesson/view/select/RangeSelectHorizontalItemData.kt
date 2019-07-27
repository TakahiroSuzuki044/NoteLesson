package com.tachisatok.notelesson.view.select

import com.tachisatok.notelesson.constant.ScaleRange
import java.io.Serializable

data class RangeSelectHorizontalItemData(
    val gClefScaleRange: ScaleRange? = null,
    val fClefScaleRange: ScaleRange? = null
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}