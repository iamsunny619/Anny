package com.starter.anny.ui.bottomnav.explore.tmdb.module

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.starter.anny.R
import com.starter.anny.databinding.FragmentTmdbHomeBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.tmdb.module.viewmodel.TmdbHomeViewModel
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_tmdb_home.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class TmdbHomeFragment : BaseBindingFragment<FragmentTmdbHomeBinding>() {
    override val content: Int
        get() = R.layout.fragment_tmdb_home

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private val tmdbHomeViewModel by activityViewModels<TmdbHomeViewModel> { viewModelProvider }

    override fun viewModelSetUp() {

        tmdbHomeViewModel.getPopularMovies("f4431f3dd6ef45670c96801a8a47080a")

        tmdbHomeViewModel.getTmdbPopularMovies?.observe(this) {
            Log.d("found", it.toString())
        }
    }

    override fun viewSetUp() {

        AppUtils.setTransparentStatusColor(requireActivity(), true, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).run {
                setSupportActionBar(toolbar)
            }
        }
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }


}