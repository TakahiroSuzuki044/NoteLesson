package com.tachisatok.notelesson.view.setting

import android.os.Bundle
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.view.base.BaseActivityForBackStack

class SettingActivity : BaseActivityForBackStack() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_activity)
    }

    override fun getStackFragment() = SettingFragment()
}