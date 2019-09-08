package com.tachisatok.notelesson.analysis

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.tachisatok.notelesson.BuildConfig
import com.tachisatok.notelesson.constant.PREFERENCES_KEY_FIRST_BOOT_DAY
import com.tachisatok.notelesson.constant.PREFERENCES_KEY_SAVED_UUID
import com.tachisatok.notelesson.util.FormatUtil
import com.tachisatok.notelesson.util.PreferenceUtil
import java.util.*

class FirebaseAnalyticsManager(
    val context: Context
) {
    private val firebaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    var uuid: String =
        PreferenceUtil.getString(context, PREFERENCES_KEY_SAVED_UUID)?.let {
            it
        } ?: UUID.randomUUID().toString()

    var firstBootDay: String =
        PreferenceUtil.getString(context, PREFERENCES_KEY_FIRST_BOOT_DAY)?.let {
            it
        } ?: FormatUtil.getDay(Date(), FormatUtil.DATE_PATTERN_DEFAULT_ANALYSIS)

    init {
        PreferenceUtil.putString(context, PREFERENCES_KEY_SAVED_UUID, uuid)
        PreferenceUtil.putString(context, PREFERENCES_KEY_FIRST_BOOT_DAY, firstBootDay)
    }

    /**
     * ログを送信する
     */
    fun sendLog(contentType: String, params: List<String> = listOf()) {
        val itemId = getParam(params)
        if (canSend()) {
            val param = Bundle()
            param.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
            param.putString(FirebaseAnalytics.Param.ITEM_ID, itemId)
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, param)
        } else {
            logging(contentType, itemId)
        }
    }

    /**
     * パラメータを設定する
     */
    private fun getParam(params: List<String>): String {
        val paramList = mutableListOf<String>()

        // デフォルトのパラメータを付与
        paramList.add(uuid)
        paramList.add(firstBootDay)
        paramList.add(getTimeStamp())

        // 個別パラメータを付与
        paramList.addAll(params)

        // パラメータをアンダーバーで結合する
        return paramList.joinToString(separator = UNDER_BAR)
    }

    /**
     * ログの送信可否を返却する
     */
    private fun canSend() = !BuildConfig.DEBUG

    /**
     * 現在時刻を返却する
     */
    private fun getTimeStamp() = FormatUtil.getDay(Date(), FormatUtil.DATE_PATTERN_DEFAULT_ANALYSIS)


    /**
     * Logcatにロギングする
     *
     * @param contentType コンテンツタイプ
     * @param msg ロギングするメッセージ
     */
    private fun logging(contentType: String, msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "$contentType : ${msg ?: ""}")
        }
    }

    companion object {
        private const val UNDER_BAR: String = "_"
        private val TAG = FirebaseAnalyticsManager::class.java.simpleName
    }
}