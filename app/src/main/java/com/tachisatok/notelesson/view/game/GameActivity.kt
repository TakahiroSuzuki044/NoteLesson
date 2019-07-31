package com.tachisatok.notelesson.view.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.view.base.BaseActivity
import com.tachisatok.notelesson.view.select.RangeSelectHorizontalItemData

class GameActivity : BaseActivity() {

    val itemData by lazy { (intent.getSerializableExtra(INTENT_KEY_ITEM_DATA) as RangeSelectHorizontalItemData) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.game_activity)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.game_activity_content, GamePlayingFragment())
            commit()
        }
    }

    companion object {
        /**
         * INTENT KEY：選択した[RangeSelectHorizontalItemData]
         */
        private const val INTENT_KEY_ITEM_DATA = "intent_key_range_select_horizontal_item_data"

        /**
         * [GameActivity]を起動するIntentを返却する
         */
        @JvmStatic
        fun newIntent(
            context: Context,
            rangeSelectHorizontalItemData: RangeSelectHorizontalItemData
        ): Intent {
            return Intent(context, GameActivity::class.java)
                .putExtra(INTENT_KEY_ITEM_DATA, rangeSelectHorizontalItemData)
        }
    }
}