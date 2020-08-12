package com.tachisatok.notelesson.view.debug

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.view.base.BaseActivity
import kotlinx.android.synthetic.main.debug_activity.*
import java.lang.RuntimeException

class DebugActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.debug_activity)

        initView()
    }

    /**
     * Viewの初期化処理
     */
    private fun initView() {
        setView(force_crash_layout, R.string.force_crash)
    }

    /**
     * Viewの各設定を行う
     */
    private fun setView(v: View, res: Int) {
        v.isClickable = true
        v.isFocusable = true
        v.setOnClickListener(this)
        val textView = v.findViewById<TextView>(R.id.section_list_text_view)
        textView.text = getString(res)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.force_crash_layout -> {
                throw RuntimeException("Test Crash")
            }
        }
    }
}