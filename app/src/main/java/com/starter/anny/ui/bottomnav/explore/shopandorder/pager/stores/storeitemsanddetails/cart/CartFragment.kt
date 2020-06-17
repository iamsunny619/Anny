package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import com.starter.anny.R
import com.starter.anny.databinding.FragmentCartBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart.adapter.ShopAndPickUpMyCartAdapter
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import com.starter.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_store_items_and_buy.*
import kotlinx.android.synthetic.main.item_shop_and_pick_up_my_cart.*
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.math.log

class CartFragment : BaseBindingFragment<FragmentCartBinding>(), View.OnClickListener {
    override val content: Int
        get() = R.layout.fragment_cart

    private val parentNavController
        get() = requireParentFragment().findNavController()

    private var itemPrice = 0.0

    private val argsData: CartFragmentArgs by navArgs()
    private var data: List<StoreItemModel>? = ArrayList()
    private var items: MutableList<StoreItemModel>? = ArrayList()
    private var deliveryAdapter: ArrayAdapter<String>? = null
    private lateinit var shopAndPickUpMyCartAdapter: ShopAndPickUpMyCartAdapter

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
        btnPayAmount.setOnClickListener(this)

        initData()
        initCartDataRV()
    }

    private fun initCartDataRV() {
        data?.forEachIndexed { _, storeItemModel ->
            if (storeItemModel.itemCount!! > 0) {
                items?.add(storeItemModel)
                //  itemPrice += storeItemModel.itemPrice?.toDouble() ?: 0.0
                itemPrice = (storeItemModel.itemCount!! * storeItemModel.itemPrice!!).toDouble()
            }
        }
        if (itemPrice < 0) {
            itemPrice = 0.0
        }
        setPrice(itemPrice)
        Log.d("aaa", items.toString())

        items?.let {
            val demo: List<StoreItemModel> = it
            shopAndPickUpMyCartAdapter =
                ShopAndPickUpMyCartAdapter(demo) { view, position, item ->
                    Log.d("count", item?.itemCount.toString())
                    when (view.id) {
                        R.id.imgPlus -> {
                            if (item?.itemChanged == true) {

                                itemPrice = (item.itemCount!! * item.itemPrice!!).toDouble()
                            }
                        }
                        R.id.imgMinus -> {
                            if (item?.itemChanged == true) {
                                itemPrice -= item.itemPrice?.toDouble() ?: 0.0
                            }
                        }
                        R.id.ibDelete -> {
                            items?.remove(item)
                        }
                    }
                    if (itemPrice < 0)
                        itemPrice = 0.0
                    setPrice(itemPrice)
                }
            rvMyCart.setHasFixedSize(true)
            rvMyCart.itemAnimator = DefaultItemAnimator()
            rvMyCart.adapter = shopAndPickUpMyCartAdapter

        }
    }

    @SuppressLint("SetTextI18n")
    private fun setPrice(itemPrice: Double) {
        txtItemTotalValue.text = getString(R.string.dollar_symbol_f, itemPrice)
        txtTaxesAndChargesValue.text = getString(R.string.dollar_symbol_f, (0.18 * itemPrice))
        val total = itemPrice + (0.18 * itemPrice)
        txtTotalValue.text = getString(R.string.dollar_symbol_f, total)
        btnPayAmount.text = getString(R.string.pay_dollar_symbol_f, total)
    }

    private fun initData() {
        data = argsData.cartItemFound?.toList()
    }

    override fun onStart() {
        super.onStart()
        initDeliveryAdapter()
    }

    private fun initDeliveryAdapter() {
        deliveryAdapter = ArrayAdapter(
            requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.shop_and_pickup_delivery_options)
        )
        tieDeliveryOption.setAdapter(deliveryAdapter)
        tieDeliveryOption.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                txtSelectDate.visibility = View.VISIBLE
                rvSelectDate.visibility = View.VISIBLE
                txtSelectTime.visibility = View.VISIBLE
                rvSelectTime.visibility = View.VISIBLE
            } else {
                txtSelectDate.visibility = View.GONE
                rvSelectDate.visibility = View.GONE
                txtSelectTime.visibility = View.GONE
                rvSelectTime.visibility = View.GONE
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPayAmount -> {
                val args =
                    CartFragmentDirections.actionCartFragmentToSuccessMessageBottomSheetFragment(
                        items?.toTypedArray()
                    )
                parentNavController.navigate(args)
            }
        }
    }
}