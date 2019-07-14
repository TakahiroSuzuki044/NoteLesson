package com.tachisatok.notelesson.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil {

    companion object {
        /**
         * [SharedPreferences]に保存するファイル名
         */
        private const val NOTE_LESSON_SHARED_PREFERENCES_FILE = "note_lesson_shared_preferences_file"

        /**
         * [SharedPreferences]に保存する
         */
        @JvmStatic
        fun putString(context: Context, key: String, value: String) {
            getEdit(context).putString(key, value).apply()
        }

        /**
         * [SharedPreferences]に保存した値を返却する
         */
        @JvmStatic
        fun getString(context: Context, key: String): String? {
            return getSharedPreferences(context).getString(key, null)
        }

        /**
         * [SharedPreferences.Editor]を返却する
         */
        private fun getEdit(context: Context): SharedPreferences.Editor {
            return getSharedPreferences(context).edit()
        }

        /**
         * [SharedPreferences]を返却する
         */
        private fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(NOTE_LESSON_SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE)
        }
    }
}