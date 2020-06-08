package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.starter.anny.R
import com.starter.anny.databinding.ItemShopItemToBuyBinding
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model.StoreItemModel
import kotlinx.android.synthetic.main.item_shop_item_to_buy.view.*

class StoreItemAdapter(
    items: List<StoreItemModel>,
    private val itemClick: (view: View, position: Int, itemModel: StoreItemModel?) -> Unit
) :
    RecyclerView.Adapter<StoreItemAdapter.ViewHolder>() {

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
                R.layout.item_shop_item_to_buy,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener(holder)
        holder.itemView.imgPlus.setOnClickListener(holder)
        holder.itemView.imgMinus.setOnClickListener(holder)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ViewHolder(private val binding: ItemShopItemToBuyBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            val item = items[adapterPosition]
            v?.let {
                when (v.id) {
                    R.id.imgPlus -> {
                        if (itemCount < 100) {
                            item.itemCount = item.itemCount?.plus(1)
                            binding.txtNumbers.text = item.itemCount.toString()
                            item.itemChanged = true
                            //notifyItemChanged(adapterPosition)
                        } else {
                            item.itemChanged = false
                        }
                    }
                    R.id.imgMinus -> {
                        if (Integer.parseInt(binding.txtNumbers.text.toString()) > 0) {
                            item.itemCount = item.itemCount?.minus(1)
                            binding.txtNumbers.text = item.itemCount.toString()
                            item.itemChanged = true
                            // notifyItemChanged(adapterPosition)
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
            binding.storeItemModel = items[position]
            binding.executePendingBindings()
        }
    }
}


