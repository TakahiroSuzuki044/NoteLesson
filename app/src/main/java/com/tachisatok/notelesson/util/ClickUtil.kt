package com.tachisatok.notelesson.util

class ClickUtil {
    companion object {

        /**
         * １秒未満のイベントは無視
         */
        private const val DELAY = 1000
        /**
         * 前回イベント実施時刻
         */
        @JvmStatic
        private var sOldTime: Long = 0

        /**
         * クリック可能かを判断する
         *
         * @return クリック可能の場合、True
         */
        @JvmStatic
        fun isClickable(): Boolean {
            // 今の時間を覚える
            val time = System.currentTimeMillis()

            // 前回の時間と比較してdelay秒以上経っていないと無視
            if (time - sOldTime < DELAY) {
                return false
            }

            // 一定時間経過したら実行可能とする
            sOldTime = time
            return true
        }
    }
}