package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.cart.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.starter.anny.R
import com.starter.anny.databinding.ItemShopAndPickUpMyCartBinding
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import com.starter.anny.ui.utils.showView
import kotlinx.android.synthetic.main.item_shop_and_pick_up_my_cart.view.*
import timber.log.Timber

class ShopAndPickUpMyCartAdapter(
    items: List<StoreItemModel>,
    private val itemClick: (view: View, position: Int, item: StoreItemModel?) -> Unit
) :
    RecyclerView.Adapter<ShopAndPickUpMyCartAdapter.ViewHolder>() {

    // refresh items
    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_shop_and_pick_up_my_cart,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener(holder)
        holder.itemView.imgMinus.setOnClickListener(holder)
        holder.itemView.imgPlus.setOnClickListener(holder)
        holder.itemView.ibDelete.setOnClickListener(holder)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ViewHolder(private val binding: ItemShopAndPickUpMyCartBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            val item = items[adapterPosition]
            Log.d("adapteraaa",item.toString())
            v?.let {
                when (v.id) {
                    R.id.imgMinus -> {
                        if (item.itemCount!! > 0) {
                            item.itemCount = item.itemCount?.minus(1)
                            item.itemChanged = true
                            notifyItemChanged(adapterPosition)
                        } else {
                            item.itemChanged = false
                        }
                    }
                    R.id.imgPlus -> {
                        if (item.itemCount!! < 100) {
                            item.itemCount = item.itemCount?.plus(1)
                            item.itemChanged = true
                            notifyItemChanged(adapterPosition)
                        } else {
                            item.itemChanged = false
                        }
                    }
                }
                itemClick.invoke(it, adapterPosition, item)
            }
        }

        fun bind(
            position: Int
        ) {
            val item = items[position]
            binding.items = item
            binding.executePendingBindings()
            binding.txtQuantity.showView()
            binding.txtQuantity.text =binding.txtQuantity.context.getString(R.string.s_s)
        }
    }
}
