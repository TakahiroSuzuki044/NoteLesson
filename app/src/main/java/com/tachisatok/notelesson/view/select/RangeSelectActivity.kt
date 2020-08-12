package com.tachisatok.notelesson.view.select

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tachisatok.notelesson.BuildConfig
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.analysis.EVENT_RANGE_SELECT_TAP_ITEM
import com.tachisatok.notelesson.analysis.FirebaseAnalyticsManager
import com.tachisatok.notelesson.analysis.PAGE_VIEW_RANGE_SELECT
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.constant.Clef
import com.tachisatok.notelesson.constant.Octave
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.util.ClickUtil
import com.tachisatok.notelesson.view.base.BaseActivity
import com.tachisatok.notelesson.view.game.GameActivity
import com.tachisatok.notelesson.view.setting.SettingActivity
import com.tachisatok.notelesson.view.ui.OnItemClickCallback
import kotlinx.android.synthetic.main.range_select_activity.*

class RangeSelectActivity : BaseActivity(), OnItemClickCallback {

    private val firebaseAnalyticsManager by lazy { FirebaseAnalyticsManager(this) }

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

        range_select_toolbar.title = Characters.RANGE_SELECT_TITLE.getString(this)
        range_select_toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        setSupportActionBar(range_select_toolbar)

        enableCrashlytics()
    }

    override fun onResume() {
        super.onResume()
        firebaseAnalyticsManager.sendLog(PAGE_VIEW_RANGE_SELECT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_manu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.home_setting -> {

                val intent = Intent(applicationContext, SettingActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_START_SETTING)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(view: View, item: Any, position: Int) {
        if (item is ScaleRange && ClickUtil.isClickable()) {
            val intent = GameActivity.newIntent(this, item)
            startActivity(intent)

            firebaseAnalyticsManager.sendLog(EVENT_RANGE_SELECT_TAP_ITEM, listOf(item.name))
        }
    }

    private fun enableCrashlytics() {
        if (BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        }
    }

    companion object {
        private const val REQUEST_CODE_START_SETTING = 1
    }
}