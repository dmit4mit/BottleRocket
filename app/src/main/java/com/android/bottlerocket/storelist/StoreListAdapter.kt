package com.android.bottlerocket.storelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.bottlerocket.R
import com.android.bottlerocket.data.model.Store
import kotlinx.android.synthetic.main.item_store.view.*

class StoreListAdapter : ListAdapter<Store, StoreListAdapter.StoreViewHolder>(DIFF_CALLBACK) {

    private val onClickListener: View.OnClickListener = View.OnClickListener {
        val item = it.tag as Store
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        StoreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_store, parent, false))

    override fun onBindViewHolder(holderStore: StoreViewHolder, position: Int) {
        holderStore.apply {
            val item = getItem(position)
            bindTo(item)
            itemView.tag = item
        }
    }

    inner class StoreViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindTo(store: Store) = with(view) {
            item_store_name_tv.text = store.name
            item_store_address_value_tv.text = store.address
            item_store_phone_value_tv.text = store.phone
            setOnClickListener(onClickListener)
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