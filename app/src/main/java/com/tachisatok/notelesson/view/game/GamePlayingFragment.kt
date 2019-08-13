package com.tachisatok.notelesson.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.databinding.GamePlayingFragmentBinding
import com.tachisatok.notelesson.view.select.RangeSelectHorizontalItemData

class GamePlayingFragment : Fragment() {

    private val itemData by lazy { (arguments?.getSerializable(ARGS_KEY_ITEM_DATA) as RangeSelectHorizontalItemData) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GamePlayingFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.game_playing_fragment, container, false)
        binding.viewModel = GamePlayingViewModel(context!!, itemData.gClefScaleRange, itemData.fClefScaleRange)

        return binding.root
    }

    companion object {
        /**
         * ARGS KEY：選択した[RangeSelectHorizontalItemData]
         */
        private const val ARGS_KEY_ITEM_DATA = "args_key_item_data"

        @JvmStatic
        fun getInstance(rangeSelectHorizontalItemData: RangeSelectHorizontalItemData): GamePlayingFragment =
                GamePlayingFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARGS_KEY_ITEM_DATA, rangeSelectHorizontalItemData)
                    }
                }
    }
}