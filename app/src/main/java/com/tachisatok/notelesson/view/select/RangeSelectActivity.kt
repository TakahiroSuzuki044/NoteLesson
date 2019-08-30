package com.tachisatok.notelesson.view.select

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Clef
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.view.base.BaseActivity
import com.tachisatok.notelesson.view.game.GameActivity
import com.tachisatok.notelesson.view.ui.OnItemClickCallback
import kotlinx.android.synthetic.main.range_select_activity.*

class RangeSelectActivity : BaseActivity(), OnItemClickCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.range_select_activity)

        range_select_activity_recycler_view.adapter = RangeSelectRecyclerAdapter(
            this,
            listOf(),
            ScaleRange.of(Clef.G_CLEF),
            ScaleRange.of(Clef.F_CLEF),
            this
        )
        range_select_activity_recycler_view.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onItemClick(view: View, item: Any, position: Int) {
        if (item is RangeSelectHorizontalItemData) {
            val intent = GameActivity.newIntent(this, item)
            startActivity(intent)
        }
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