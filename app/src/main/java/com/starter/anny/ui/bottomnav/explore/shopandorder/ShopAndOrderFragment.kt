package com.starter.anny.ui.bottomnav.explore.shopandorder

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.starter.anny.R
import com.starter.anny.databinding.FragmentShopAndOrderBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pageradapter.ShopAndOrderPagerAdapter
import com.starter.anny.ui.utils.app.AppUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_shop_and_order.*
import kotlinx.coroutines.launch

class ShopAndOrderFragment : BaseBindingFragment<FragmentShopAndOrderBinding>() {
    override val content: Int
        get() = R.layout.fragment_shop_and_order

    private lateinit var shopAndOrderPagerAdapter: ShopAndOrderPagerAdapter

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), true, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolbar)
            }
        }
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        initViewPagerAndTabLayout()
    }

    private fun initViewPagerAndTabLayout() {
        shopAndOrderPagerAdapter = ShopAndOrderPagerAdapter(requireParentFragment())
        viewPagerShop.adapter = shopAndOrderPagerAdapter

        TabLayoutMediator(tabLayout, viewPagerShop) { tab, position ->
            viewPagerShop.setCurrentItem(tab.position, true)
            when (position) {
                0 -> {
                    tab.text = "Stores"
                }
                1 -> {
                    tab.text = "Homes"
                }
                2 -> {
                    tab.text = "Demos"
                }

            }
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }
        })
    }
}
