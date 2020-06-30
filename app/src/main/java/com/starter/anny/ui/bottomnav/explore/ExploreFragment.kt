package com.starter.anny.ui.bottomnav.explore

import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import com.starter.anny.R
import com.starter.anny.databinding.FragmentExploreBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.adapter.ExploreItemAdapter
import com.starter.anny.ui.bottomnav.explore.model.ExploreItemModel
import com.starter.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderHostActivity
import com.starter.anny.ui.bottomnav.explore.tmdb.TMDBHostActivity
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : BaseBindingFragment<FragmentExploreBinding>() {
    override val content: Int
        get() = R.layout.fragment_explore

    val img1: Int = R.drawable.bg_img_dummydemo
    val img2: Int = R.drawable.bg_img_food_dummy
    val img3: Int = R.drawable.bg_img_food_dummy

    private lateinit var exploreItemAdapter: ExploreItemAdapter

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        exploreItemAdapter = ExploreItemAdapter(
            listOf(
                ExploreItemModel(img1, "LiveData", true),
                ExploreItemModel(img2, "MovieDb", true),
                ExploreItemModel(img3, "ShopAndOrder", false)
            )
        ) { _, position, items ->
            run {
                if (items?.isActive == true) {
                    Boast.makeText(
                        requireContext(),
                        "name= " + items.itemName + "is clicked at position=" + position,
                        Toast.LENGTH_SHORT
                    ).show()
                    when (position) {
                        0 -> {
                            startActivity(
                                Intent(
                                    requireContext(),
                                    ShopAndOrderHostActivity::class.java
                                )
                            )
                        }
                        1 -> {
                            startActivity(Intent(requireContext(), TMDBHostActivity::class.java))
                        }
                    }
                } else {
                    AppUtils.okDialog(requireContext(), "not active") {

                    }

                }
            }
        }
        rvExploreList.setHasFixedSize(true)
        rvExploreList.itemAnimator = DefaultItemAnimator()
        rvExploreList.adapter = exploreItemAdapter
    }

}
