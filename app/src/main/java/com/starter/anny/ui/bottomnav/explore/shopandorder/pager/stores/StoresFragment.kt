package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.starter.anny.R
import com.starter.anny.databinding.FragmentStoresBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderFragmentDirections
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.StoresModel
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.rcadapter.StoreShopListAdapter
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.hideSoftInput
import kotlinx.android.synthetic.main.fragment_stores.*

class StoresFragment : BaseBindingFragment<FragmentStoresBinding>(),
    SwipeRefreshLayout.OnRefreshListener {
    override val content: Int
        get() = R.layout.fragment_stores

    private val parentNavController
        get() = requireParentFragment().findNavController()

    val img1: Int = R.drawable.bg_img_food_dummy
    val img2: Int = R.drawable.bg_img_dummydemo
    val img3: Int = R.drawable.bg_img_food_dummy

    private lateinit var storeShopListAdapter: StoreShopListAdapter

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {

        initShopListRecycler()
        swipeRL.setOnRefreshListener(this)

    }

    private fun initShopListRecycler() {
        storeShopListAdapter =
            StoreShopListAdapter(
                listOf(
                    StoresModel(img1, "Patel Brothers", "andhari naka"),
                    StoresModel(img2, "Chouhan Brothers", "Raipur"),
                    StoresModel(img3, "Some Shop", "Somewhere"),
                    StoresModel(img1, "Shau Dhukaan", "KatulBoard"),
                    StoresModel(img2, "KatulBoard Shop", "Nepali Para"),
                    StoresModel(img2, "KatulBoard Shop", "Nepali Para"),
                    StoresModel(img2, "KatulBoard Shop", "Nepali Para"),
                    StoresModel(img2, "KatulBoard Shop", "Nepali Para"),
                    StoresModel(img2, "KatulBoard Shop", "Nepali Para")
                )
            ) { _, _, item ->
                item?.let {
                    Boast.makeText(requireContext(), item.shopName.toString(), Toast.LENGTH_SHORT)
                        .show()
                    val args =
                        ShopAndOrderFragmentDirections.actionShopAndOrderFragmentToStoreItemsAndBuyFragment(
                            it
                        )
                    parentNavController.navigate(args)
                }
            }
        rvShopStoresList.setHasFixedSize(true)
        rvShopStoresList.itemAnimator = DefaultItemAnimator()
        rvShopStoresList.adapter = storeShopListAdapter
    }

    override fun onRefresh() {
        Boast.makeText(requireContext(), "refreshed", Toast.LENGTH_SHORT).show()
        swipeRL.isRefreshing = false
        swipeRL.hideSoftInput()
    }
}