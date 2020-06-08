package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import com.starter.anny.R
import com.starter.anny.databinding.FragmentStoreItemsAndBuyBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.rvAdapter.StoreItemAdapter
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_store_items_and_buy.*
import kotlinx.coroutines.launch

class StoreItemsAndBuyFragment : BaseBindingFragment<FragmentStoreItemsAndBuyBinding>() {
    override val content: Int
        get() = R.layout.fragment_store_items_and_buy

    private lateinit var storeItemAdapter: StoreItemAdapter

    private val argsData: StoreItemsAndBuyFragmentArgs by navArgs()

    val img1: Int = R.drawable.bg_img_food_dummy
    val img2: Int = R.drawable.bg_img_dummydemo
    val img3: Int = R.drawable.bg_img_food_dummy

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), false, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolBar)
            }
        }
        toolBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        initInflateData()
        initRecyclerView()
    }

    private fun initInflateData() {
        binding.storeModel = argsData.shopDetails
        binding.txtAddress.text = argsData.shopDetails?.shopAddress
    }

    private fun initRecyclerView() {
        storeItemAdapter = StoreItemAdapter(
            listOf(
                StoreItemModel("Chai Nasta", "Mast Swadist Chai", "50ml", 10, img1),
                StoreItemModel("Garam Poha", "Mast Swadist Poha", "180gm", 19, img2),
                StoreItemModel("Cake", "Mast Swadist Cake", "150gm", 100, img3)
            )
        ) { _, _, _ -> }
        rvShopItems.setHasFixedSize(true)
        rvShopItems.itemAnimator = DefaultItemAnimator()
        rvShopItems.adapter = storeItemAdapter
    }
}