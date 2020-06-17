package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart.successbottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.starter.anny.R
import com.starter.anny.databinding.FragmentSuccessMessgaeBottomSheetBinding
import com.starter.anny.ui.base.BaseBindingBottomSheetDialog
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import kotlinx.android.synthetic.main.fragment_success_messgae_bottom_sheet.*

class SuccessMessageBottomSheetFragment :
    BaseBindingBottomSheetDialog<FragmentSuccessMessgaeBottomSheetBinding>(),
    View.OnClickListener {
    override val contentView: Int
        get() = R.layout.fragment_success_messgae_bottom_sheet

    private val navController
    get() = requireParentFragment().findNavController()

    private val args: SuccessMessageBottomSheetFragmentArgs by navArgs()
    private var modelData: List<StoreItemModel>? = ArrayList()

    override fun viewModelSetup() {
    }

    override fun viewSetup() {
        isCancelable = true
        imgClose.setOnClickListener(this)
        btnViewOrderDetail.setOnClickListener(this)
        initDatas()
    }

    private fun initDatas() {
        modelData = args.sheetData?.toList()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imgClose -> {
                dismiss()
            }
            R.id.btnViewOrderDetail -> {
                dismiss()
                val navs =
                    SuccessMessageBottomSheetFragmentDirections.actionSuccessMessageBottomSheetFragmentToOrderDetailsFragment(
                        modelData?.toTypedArray()
                    )
                navController.navigate(navs)

            }
        }
    }

}