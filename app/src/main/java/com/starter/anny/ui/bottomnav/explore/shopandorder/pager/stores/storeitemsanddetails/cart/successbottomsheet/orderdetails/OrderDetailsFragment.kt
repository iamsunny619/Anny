package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart.successbottomsheet.orderdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.starter.anny.R
import com.starter.anny.databinding.FragmentOrderDetailsBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_order_details.*
import kotlinx.coroutines.launch

class OrderDetailsFragment : BaseBindingFragment<FragmentOrderDetailsBinding>() {
    override val content: Int
        get() = R.layout.fragment_order_details

    private val datas: OrderDetailsFragmentArgs by navArgs()
    private var modelData: List<StoreItemModel>? = ArrayList()

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), true, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolbar)
            }
        }
        toolbar.title = "details"
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        initDatas()
        initView()
    }

    private fun initView() {
        binding.txtItemCount.text = modelData?.get(0)?.itemCount.toString()
        binding.txtItemName.text = modelData?.get(0)?.itemName.toString()
        binding.txtTotalPrice.text = modelData?.get(0)?.itemPrice.toString()
    }

    private fun initDatas() {
        modelData = datas.orderDetails?.toList()
    }
}