package com.tachisatok.notelesson.util

import android.content.Intent
import android.net.Uri
import com.tachisatok.notelesson.constant.APP_PRIVACY_POLICY_URL
import com.tachisatok.notelesson.constant.APP_TERM_OF_SERVICE_URL

class ShareUtil {

    companion object {

        /**
         * プライバシーポリシーを表示するためにブラウザを起動するIntentを返却する
         *
         * @return ブラウザを起動する [Intent]
         */
        @JvmStatic
        fun getPrivacyPolicyUri(): Intent {
            val uri = Uri.parse(APP_PRIVACY_POLICY_URL)
            return Intent(Intent.ACTION_VIEW, uri)
        }

        /**
         * ご利用規約を表示するためにブラウザを起動するIntentを返却する
         *
         * @return ブラウザを起動する [Intent]
         */
        @JvmStatic
        fun geTermOfServiceUri(): Intent {
            val uri = Uri.parse(APP_TERM_OF_SERVICE_URL)
            return Intent(Intent.ACTION_VIEW, uri)
        }
    }
}