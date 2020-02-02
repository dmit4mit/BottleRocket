package com.android.bottlerocket.storelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.databinding.LayoutItemStoreBinding

class StoreListAdapter : ListAdapter<Store, StoreListAdapter.StoreViewHolder>(DIFF_CALLBACK) {

    private val onClickListener: View.OnClickListener = View.OnClickListener {
        val item = it.tag as Store
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        StoreViewHolder(LayoutItemStoreBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holderStore: StoreViewHolder, position: Int) {
        holderStore.apply {
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