package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import com.starter.anny.R
import com.starter.anny.databinding.FragmentStoreItemsAndBuyBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.rvAdapter.StoreItemAdapter
import com.starter.anny.ui.utils.Boast
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_store_items_and_buy.*
import kotlinx.coroutines.launch
import timber.log.Timber

class StoreItemsAndBuyFragment : BaseBindingFragment<FragmentStoreItemsAndBuyBinding>(),
    View.OnClickListener {
    override val content: Int
        get() = R.layout.fragment_store_items_and_buy

    private lateinit var storeItemAdapter: StoreItemAdapter

    private val argsData: StoreItemsAndBuyFragmentArgs by navArgs()

    val img1: Int = R.drawable.bg_img_food_dummy
    val img2: Int = R.drawable.bg_img_dummydemo
    val img3: Int = R.drawable.bg_img_food_dummy

    private var numberItem = 0
    private var totalPrice: Double = 0.0

    private var itemSelectedFromModel: List<StoreItemModel> = emptyList()
    private val navController
        get() = requireParentFragment().findNavController()

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
        btnGoToCart.setOnClickListener(this)
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
        ) { view, _, itemModel ->
            itemSelectedFromModel = listOf(itemModel!!)
            when (view.id) {
                R.id.imgPlus -> {
                    if (itemModel?.itemChanged == true) {
                        numberItem += 1
                        totalPrice += itemModel.itemPrice!!.toDouble()
                        binding.txtItemCount.text =
                            numberItem.toString() + " item"
                        binding.txtItemPriceTotal.text = totalPrice.toString() + " Rs"
                    }
                }

                R.id.imgMinus -> {
                    if (numberItem > 0 && totalPrice > 0 && itemModel?.itemChanged == true) {
                        numberItem -= 1
                        totalPrice -= itemModel.itemPrice!!.toDouble()
                        binding.txtItemCount.text =
                            numberItem.toString() + " item"
                        binding.txtItemPriceTotal.text = totalPrice.toString() + " Rs"

                    } else {
                        Boast.makeText(requireContext(), "nothing added", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        rvShopItems.setHasFixedSize(true)
        rvShopItems.itemAnimator = DefaultItemAnimator()
        rvShopItems.adapter = storeItemAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGoToCart -> {
                if (numberItem <= 0 && totalPrice <= 0) {
                    Boast.makeText(
                        requireContext(),
                        "atleast on Item has to be added on list",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (numberItem > 0 && totalPrice > 0) {
                        val args =
                            StoreItemsAndBuyFragmentDirections.actionStoreItemsAndBuyFragmentToCartFragment(
                                itemSelectedFromModel.toTypedArray()
                            )
                        navController.navigate(args)
                    } else {
                        Timber.d("item and prices is zero dont know what happened")
                    }
                }
            }
        }
    }
}