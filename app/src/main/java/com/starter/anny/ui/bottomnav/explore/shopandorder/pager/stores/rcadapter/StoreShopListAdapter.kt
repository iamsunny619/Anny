package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.rcadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.starter.anny.R
import com.starter.anny.databinding.ItemShopPagerStoresBinding
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.StoresModel

class StoreShopListAdapter(
    items: List<StoresModel>,
    private val itemClick: (view: View, position: Int, storeModel: StoresModel?) -> Unit
) :
    RecyclerView.Adapter<StoreShopListAdapter.ViewHolder>() {

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
                R.layout.item_shop_pager_stores,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener(holder)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ViewHolder(private val binding: ItemShopPagerStoresBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let {
                itemClick.invoke(it, adapterPosition, items[adapterPosition])
            }
        }

        fun bind(
            position: Int
        ) {
            binding.storeModel = items[position]
            binding.executePendingBindings()
        }
    }
}


