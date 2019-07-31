package com.tachisatok.notelesson.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.databinding.GamePlayingFragmentBinding

class GamePlayingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GamePlayingFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.game_playing_fragment, container, false)

        return binding.root
    }
}