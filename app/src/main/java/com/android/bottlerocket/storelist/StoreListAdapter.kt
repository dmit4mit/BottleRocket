package com.android.bottlerocket.storelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.databinding.LayoutItemStoreBinding

class StoreListAdapter(val onClickListener: View.OnClickListener) : ListAdapter<Store, StoreListAdapter.StoreViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        StoreViewHolder(LayoutItemStoreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(storeViewHolder: StoreViewHolder, position: Int) {
        storeViewHolder.apply {
            val item = getItem(position)
            bindTo(item)
            itemView.tag = item
        }
    }

    inner class StoreViewHolder(private val binding: LayoutItemStoreBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: Store) = binding.apply {
            store = item
            clickListener = onClickListener
            binding.itemStoreLogoImg.load(item.storeLogoURL)
            binding.executePendingBindings()
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Store>() {
            override fun areItemsTheSame(oldItem: Store, newItem: Store) =
                oldItem.storeID == newItem.storeID

            override fun areContentsTheSame(oldItem: Store, newItem: Store) =
                oldItem == newItem
        }
    }
}