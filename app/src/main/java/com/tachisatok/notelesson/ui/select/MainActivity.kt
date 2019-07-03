package com.tachisatok.notelesson.ui.select

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.databinding.ActivityMainBinding
import com.tachisatok.notelesson.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.activityMainLevelCardLinearLayout1.activityMainLevelImageView.setImageResource(R.mipmap.level_1)
        binding.activityMainLevelCardLinearLayout2.activityMainLevelImageView.setImageResource(R.mipmap.level_2)
        binding.activityMainLevelCardLinearLayout3.activityMainLevelImageView.setImageResource(R.mipmap.level_3)
    }

}
