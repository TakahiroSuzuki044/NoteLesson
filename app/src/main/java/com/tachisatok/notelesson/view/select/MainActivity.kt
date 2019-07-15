package com.tachisatok.notelesson.view.select

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.GameLevel
import com.tachisatok.notelesson.databinding.MainActivityBinding
import com.tachisatok.notelesson.view.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        binding.viewModel =
            ViewModelProviders.of(this, LevelSelectViewModel.LevelSelectViewModelFactory(this)).get(LevelSelectViewModel::class.java)
    }

    /**
     * 範囲選択画面へ遷移する
     */
    fun onClickMoveToRangeSelect(view: View) {
        val gameLevel = view.tag as GameLevel
        val intent = RangeSelectActivity.newIntent(this, gameLevel)
        startActivity(intent)
    }
}
