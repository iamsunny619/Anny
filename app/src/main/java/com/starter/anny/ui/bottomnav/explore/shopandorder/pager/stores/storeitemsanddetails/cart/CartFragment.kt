package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.starter.anny.R
import com.starter.anny.databinding.FragmentCartBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.coroutines.launch

class CartFragment : BaseBindingFragment<FragmentCartBinding>() {
    override val content: Int
        get() = R.layout.fragment_cart

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), true, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolbar)
            }
        }
        toolbar.title = "cart"
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}