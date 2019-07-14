package com.tachisatok.notelesson.view.select

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.view.base.BaseActivity

class RangeSelectActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.range_select_activity)
    }

    companion object {
        /**
         * INTENT KEY：選択した[GameLevel]
         */
        private const val INTENT_KEY_GAME_LEVEL = "intent_key_game_level"

        /**
         * [RangeSelectActivity]を起動するIntentを返却する
         */
        fun newIntent(context: Context, gameLevel: GameLevel): Intent {
            return Intent(context, RangeSelectActivity::class.java)
                .putExtra(INTENT_KEY_GAME_LEVEL, gameLevel)
        }
    }
}