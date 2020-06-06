package com.example.anny.ui.bottomnav.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.anny.R
import com.example.anny.databinding.ItemExploreListBinding
import com.example.anny.ui.bottomnav.explore.model.ExploreItemModel

@Suppress("DEPRECATION")
class ExploreItemAdapter(
    items: List<ExploreItemModel>,
    private val itemClick: (view: View, position: Int, exploreItem: ExploreItemModel?) -> Unit
) :
    RecyclerView.Adapter<ExploreItemAdapter.ViewHolder>() {

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
                R.layout.item_explore_list,
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

    inner class ViewHolder(private val binding: ItemExploreListBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let {
                itemClick.invoke(it, adapterPosition, items[adapterPosition])
            }
        }

        fun bind(
            position: Int
        ) {
            binding.exploreModel = items[position]
            binding.executePendingBindings()
            if (items[position].isActive == true) {
                binding.cardView.isEnabled = true
                binding.cardView.alpha = 1f
            } else {
                binding.cardView.isEnabled = false
                binding.cardView.alpha = 0.6f
            }
        }
    }
}
