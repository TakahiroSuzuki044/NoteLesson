package com.tachisatok.notelesson.view.select

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.view.base.BaseActivity
import com.tachisatok.notelesson.view.select.usecase.RangeSelectItemCreator
import com.tachisatok.notelesson.view.ui.OnClickCallback
import kotlinx.android.synthetic.main.range_select_activity.*

class RangeSelectActivity : BaseActivity(), OnClickCallback {

    private val gameLevel by lazy { intent.getSerializableExtra(INTENT_KEY_GAME_LEVEL) as GameLevel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.range_select_activity)

        val rangeSelectItemCreator = RangeSelectItemCreator(gameLevel)
        range_select_activity_recycler_view.adapter = RangeSelectRecyclerAdapter(
            this,
            rangeSelectItemCreator.getGClefItem(),
            rangeSelectItemCreator.getFClefItem(),
            rangeSelectItemCreator.getGClefAndFClefItem(),
            this
        )
        range_select_activity_recycler_view.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onClick(view: View, item: Any, position: Int) {
    }


    companion object {
        /**
         * INTENT KEY：選択した[GameLevel]
         */
        private const val INTENT_KEY_GAME_LEVEL = "intent_key_game_level"

        /**
         * [RangeSelectActivity]を起動するIntentを返却する
         */
        @JvmStatic
        fun newIntent(context: Context, gameLevel: GameLevel): Intent {
            return Intent(context, RangeSelectActivity::class.java)
                .putExtra(INTENT_KEY_GAME_LEVEL, gameLevel)
        }
    }
}