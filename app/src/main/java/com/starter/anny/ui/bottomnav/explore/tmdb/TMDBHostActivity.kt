package com.starter.anny.ui.bottomnav.explore.tmdb

import android.os.Bundle
import android.util.Log
import com.starter.anny.R
import com.starter.anny.databinding.ActivityTMDBHostBinding
import com.starter.anny.ui.base.BaseBindingActivity

class TMDBHostActivity : BaseBindingActivity<ActivityTMDBHostBinding>() {
    override val contentView: Int
        get() = R.layout.activity_t_m_d_b_host

    override fun viewModelSetUp() {

    }

    override fun viewSetUp() {
        Log.d("TMDBHost", " activity created")
    }

    override fun createSavedInstanceState(savedInstanceState: Bundle?) {
    }

}