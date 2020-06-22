package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.rcadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.starter.anny.R
import com.starter.anny.databinding.ItemShopPagerStoresBinding
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.GetShopAndPickUpStoresData
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model.StoresModel
import com.starter.anny.ui.utils.extension.tryCast
import java.util.*
import kotlin.collections.ArrayList

class StoreShopListAdapter(
    items: List<GetShopAndPickUpStoresData>,
    private val itemClick: (view: View, position: Int, storeModel: GetShopAndPickUpStoresData?) -> Unit
) :
    RecyclerView.Adapter<StoreShopListAdapter.ViewHolder>(), Filterable {

    var filterableData = emptyList<GetShopAndPickUpStoresData>()

    //below to get the number of item found on search in list will invoke in fragment by lamda
    var listFound: ((Int) -> Unit)? = null

    // refresh items
    var items = items
        set(value) {
            field = value
            filterableData = value
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
        //this will invoke in fragment
        listFound?.invoke(filterableData.count())

        // return items.count()
        return filterableData.count()
    }

    inner class ViewHolder(private val binding: ItemShopPagerStoresBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let {
                itemClick.invoke(it, adapterPosition, items.get(adapterPosition))
            }
        }

        fun bind(
            position: Int
        ) {
            binding.storeModel = items[position]
            binding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    filterableData = items
                } else {
                    val resultsList: MutableList<GetShopAndPickUpStoresData> = ArrayList()
                    for (data in items) {
                        if (data.retailerName.toString().toLowerCase(Locale.getDefault()).contains(
                                charSearch.toLowerCase(Locale.getDefault())
                            )
                        // if wan to search in multiples data do
                        // || data.searchItemNames.toStirng...same
                        ) {
                            resultsList.add(data)
                        }
                    }
                    filterableData = resultsList
                }
                val filterResults = FilterResults()
                filterResults.values = filterableData
                filterResults.count = filterableData.count()
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                when (p1?.count) {
                    0 -> {

                    }
                    else -> {
                        p1?.values.tryCast<List<GetShopAndPickUpStoresData>> {
                            filterableData = this
                            listFound?.invoke(filterableData.count())
                            notifyDataSetChanged()
                        }
                    }
                }
            }
        }
    }

}


