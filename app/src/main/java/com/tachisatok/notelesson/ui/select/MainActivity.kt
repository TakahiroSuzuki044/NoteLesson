package com.tachisatok.notelesson.ui.select

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.databinding.ActivityMainBinding
import com.tachisatok.notelesson.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel =
            ViewModelProviders.of(this, LevelSelectViewModelFactory(this)).get(LevelSelectViewModel::class.java)
    }

}
