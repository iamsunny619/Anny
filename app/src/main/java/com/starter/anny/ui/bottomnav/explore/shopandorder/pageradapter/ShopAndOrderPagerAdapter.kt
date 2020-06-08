package com.starter.anny.ui.bottomnav.explore.shopandorder.pageradapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.StoresFragment

class ShopAndOrderPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            1 -> {
                return StoresFragment()
            }
            2 -> {
                return StoresFragment()
            }
            3 -> {
                return StoresFragment()
            }
        }
        return StoresFragment()
    }

}