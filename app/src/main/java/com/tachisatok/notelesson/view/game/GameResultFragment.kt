package com.tachisatok.notelesson.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.databinding.GameResultFragmentBinding
import com.tachisatok.notelesson.view.select.RangeSelectHorizontalItemData

class GameResultFragment : Fragment(), GameResultViewModel.Callback {

    private val itemData by lazy { (arguments?.getSerializable(ARGS_KEY_ITEM_DATA) as RangeSelectHorizontalItemData) }

    private val correctCount by lazy { arguments?.getInt(ARGS_KEY_CORRECT_COUNT) as Int }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameResultFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.game_result_fragment, container, false)
        binding.viewModel = GameResultViewModel(correctCount, this)

        return binding.root
    }

    override fun onClickBack() {
        activity?.finish()
    }

    override fun onClickReplay() {
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.game_activity_content, GamePlayingFragment.getInstance(itemData))
            commit()
        }
    }

    companion object {
        /**
         * ARGS KEY：選択した[RangeSelectHorizontalItemData]
         */
        private const val ARGS_KEY_ITEM_DATA = "args_key_item_data"
        /**
         * ARGS KEY：選択した[RangeSelectHorizontalItemData]
         */
        private const val ARGS_KEY_CORRECT_COUNT = "args_key_correct_count"

        @JvmStatic
        fun getInstance(
            rangeSelectHorizontalItemData: RangeSelectHorizontalItemData,
            correctCount: Int
        ): GameResultFragment =
            GameResultFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARGS_KEY_ITEM_DATA, rangeSelectHorizontalItemData)
                    putInt(ARGS_KEY_CORRECT_COUNT, correctCount)
                }
            }
    }
}