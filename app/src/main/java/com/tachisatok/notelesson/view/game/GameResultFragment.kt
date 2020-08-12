package com.tachisatok.notelesson.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.analysis.EVENT_GAME_RESULT_TAP_BACK
import com.tachisatok.notelesson.analysis.EVENT_GAME_RESULT_TAP_REPLAY
import com.tachisatok.notelesson.analysis.FirebaseAnalyticsManager
import com.tachisatok.notelesson.analysis.PAGE_VIEW_GAME_RESULT
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.databinding.GameResultFragmentBinding
import com.tachisatok.notelesson.util.ClickUtil
import kotlinx.android.synthetic.main.game_result_fragment.*

class GameResultFragment : Fragment(), GameResultViewModel.Callback {

    private val firebaseAnalyticsManager by lazy { FirebaseAnalyticsManager(requireContext()) }

    private val itemData by lazy { (arguments?.getSerializable(ARGS_KEY_ITEM_DATA) as ScaleRange) }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        game_result_toolbar.title = Characters.GAME_RESULT_TITLE.getString(requireContext())
        game_result_toolbar.setTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
    }

    override fun onResume() {
        super.onResume()
        firebaseAnalyticsManager.sendLog(PAGE_VIEW_GAME_RESULT)
    }

    override fun onClickBack() {
        if (ClickUtil.isClickable()) {
            activity?.finish()
            firebaseAnalyticsManager.sendLog(EVENT_GAME_RESULT_TAP_BACK)
        }
    }

    override fun onClickReplay() {
        if (ClickUtil.isClickable()) {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.game_activity_content, GamePlayingFragment.getInstance(itemData))
                commit()
            }
            firebaseAnalyticsManager.sendLog(EVENT_GAME_RESULT_TAP_REPLAY)
        }
    }

    companion object {
        /**
         * ARGS KEY：選択した[ScaleRange]
         */
        private const val ARGS_KEY_ITEM_DATA = "args_key_item_data"
        /**
         * ARGS KEY：正解数
         */
        private const val ARGS_KEY_CORRECT_COUNT = "args_key_correct_count"

        @JvmStatic
        fun getInstance(
            scaleRange: ScaleRange,
            correctCount: Int
        ): GameResultFragment =
            GameResultFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARGS_KEY_ITEM_DATA, scaleRange)
                    putInt(ARGS_KEY_CORRECT_COUNT, correctCount)
                }
            }
    }
}