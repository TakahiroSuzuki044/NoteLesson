package com.tachisatok.notelesson.util

import java.text.SimpleDateFormat
import java.util.*

class FormatUtil {

    companion object {
        const val DATE_PATTERN_DEFAULT_ANALYSIS = "yyyy/MM/dd/HH:mm:ss"

        /**
         * パターン指定に合わせた年月日を返却する
         *
         * @param date 日時
         * @param pattern フォーマットしたいパターン
         * @return 成形した日付文字列
         */
        fun getDay(date: Date, pattern: String): String {

            // 日時のフォーマットオブジェクト作成
            val formatter = SimpleDateFormat(pattern, Locale.JAPAN)

            // フォーマット
            return formatter.format(date)
        }

    }
}