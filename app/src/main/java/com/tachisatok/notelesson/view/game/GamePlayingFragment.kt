package com.tachisatok.notelesson.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.constant.Characters
import com.tachisatok.notelesson.constant.ScaleRange
import com.tachisatok.notelesson.databinding.GamePlayingFragmentBinding
import kotlinx.android.synthetic.main.game_playing_fragment.*

class GamePlayingFragment : Fragment(), GamePlayingViewModel.GameEndCallback {

    private val itemData by lazy { (arguments?.getSerializable(ARGS_KEY_ITEM_DATA) as ScaleRange) }

    private val TAG: String = GamePlayingFragment::class.java.simpleName

    private lateinit var globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GamePlayingFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.game_playing_fragment, container, false)
        binding.viewModel = GamePlayingViewModel(
            context!!,
            this,
            itemData
        )

        globalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rootView = view
            if (rootView != null) {
                val width = rootView.width / 4
                setAnswerWidth(game_playing_fragment_answer_layout_a, width)
                setAnswerWidth(game_playing_fragment_answer_layout_b, width)
                setAnswerWidth(game_playing_fragment_answer_layout_c, width)
                setAnswerWidth(game_playing_fragment_answer_layout_d, width)
                setAnswerWidth(game_playing_fragment_answer_layout_e, width)
                setAnswerWidth(game_playing_fragment_answer_layout_f, width)
                setAnswerWidth(game_playing_fragment_answer_layout_g, width)

                binding.root.viewTreeObserver.removeOnGlobalLayoutListener(globalLayoutListener)
            }
        }

        binding.root.viewTreeObserver.addOnGlobalLayoutListener(globalLayoutListener)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        game_playing_toolbar.title = Characters.GAME_PLAYING_TITLE.getString(requireContext())
        game_playing_toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }

    override fun onFinish(correctCount: Int) {
        fragmentManager?.beginTransaction()?.apply {
            replace(
                R.id.game_activity_content,
                GameResultFragment.getInstance(itemData, correctCount)
            )
            commit()
        }
    }

    private fun setAnswerWidth(frameLayout: FrameLayout, width: Int) {
        val params = frameLayout.layoutParams
        params.width = width
        frameLayout.layoutParams = params
    }

    companion object {
        /**
         * ARGS KEY：選択した[ScaleRange]
         */
        private const val ARGS_KEY_ITEM_DATA = "args_key_item_data"

        @JvmStatic
        fun getInstance(scaleRange: ScaleRange): GamePlayingFragment =
            GamePlayingFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARGS_KEY_ITEM_DATA, scaleRange)
                }
            }
    }
}