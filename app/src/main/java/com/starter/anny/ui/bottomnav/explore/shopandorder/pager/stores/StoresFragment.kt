package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.starter.anny.R
import com.starter.anny.databinding.FragmentStoresBinding
import com.starter.anny.di.viewmodelfactory.ViewModelFactory
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderFragmentDirections
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.StoresModel
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.rcadapter.StoreShopListAdapter
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.viewmodel.StoreFragmentViewModel
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.extension.observeNotNull
import com.starter.anny.ui.utils.hideSoftInput
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_stores.*
import javax.inject.Inject

class StoresFragment : BaseBindingFragment<FragmentStoresBinding>(),
    SwipeRefreshLayout.OnRefreshListener {
    override val content: Int
        get() = R.layout.fragment_stores

    private val parentNavController
        get() = requireParentFragment().findNavController()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val storeFragmentViewModel by activityViewModels<StoreFragmentViewModel> { viewModelFactory }

    val img1: Int = R.drawable.bg_img_food_dummy
    val img2: Int = R.drawable.bg_img_dummydemo
    val img3: Int = R.drawable.bg_img_food_dummy

    private lateinit var storeShopListAdapter: StoreShopListAdapter

    override fun viewModelSetUp() {

        storeFragmentViewModel.getStores("Blacksburg")

        storeFragmentViewModel.progressLiveData.observeNotNull(this) {
            swipeRL?.isRefreshing = if (it) {
                swipeRL.hideSoftInput()
                true
            } else false
        }

        storeFragmentViewModel.errorLiveData.observeNotNull(this) {
            Boast.makeText(requireContext(), it.message.orEmpty())
        }

        storeFragmentViewModel.getShopAndPickUpStores.observe(this, Observer {
            if (it != null && it.isNotEmpty()) {
                storeShopListAdapter.items = it
                Log.d("aaa", it.toString())
            }
        })
    }

    override fun viewSetUp() {

        initShopListRecycler()
        swipeRL.setOnRefreshListener(this)

    }

    private fun initShopListRecycler() {
        storeShopListAdapter = StoreShopListAdapter(emptyList())
        /*StoreShopListAdapter(
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
        )*/ { _, _, item ->
            Boast.makeText(requireContext(), item?.retailerName.toString(), Toast.LENGTH_SHORT)
                .show()
            //  val args =
//                    ShopAndOrderFragmentDirections.actionShopAndOrderFragmentToStoreItemsAndBuyFragment(
//                        item
//                    )
            // parentNavController.navigate(args)
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