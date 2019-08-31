package com.tachisatok.notelesson.view.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.view.base.BaseActivity

class GameActivity : BaseActivity() {

    private val itemData by lazy { (intent.getSerializableExtra(INTENT_KEY_ITEM_DATA) as ScaleRange) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.game_activity)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.game_activity_content, GamePlayingFragment.getInstance(itemData))
            commit()
        }
    }

    companion object {
        /**
         * INTENT KEY：選択した[ScaleRange]
         */
        private const val INTENT_KEY_ITEM_DATA = "intent_key_item_data"

        /**
         * [GameActivity]を起動するIntentを返却する
         */
        @JvmStatic
        fun newIntent(
            context: Context,
            scaleRange: ScaleRange
        ): Intent {
            return Intent(context, GameActivity::class.java)
                .putExtra(INTENT_KEY_ITEM_DATA, scaleRange)
        }
    }
}