package com.example.anny.ui.bottomnav.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anny.R
import com.example.anny.databinding.FragmentGameListBinding
import com.example.anny.ui.base.BaseBindingFragment

class GameListFragment : BaseBindingFragment<FragmentGameListBinding>(){
    override val content: Int
        get() = R.layout.fragment_game_list

    override fun viewModelSetUp() {}

    override fun viewSetUp() {

    }

}