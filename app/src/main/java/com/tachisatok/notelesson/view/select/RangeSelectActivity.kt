package com.tachisatok.notelesson.view.select

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Clef
import com.tachisatok.notelesson.constant.Octave
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
            ScaleRange.of(Clef.G_CLEF, Octave.FOUR),
            ScaleRange.of(Clef.G_CLEF, Octave.FIVE),
            ScaleRange.of(Clef.F_CLEF, Octave.TWO),
            ScaleRange.of(Clef.F_CLEF, Octave.THREE),
            this
        )
        range_select_activity_recycler_view.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onItemClick(view: View, item: Any, position: Int) {
        if (item is ScaleRange) {
            val intent = GameActivity.newIntent(this, item)
            startActivity(intent)
        }
    }
}