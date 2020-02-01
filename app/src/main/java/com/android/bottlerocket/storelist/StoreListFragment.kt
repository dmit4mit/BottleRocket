package com.android.bottlerocket.storelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bottlerocket.R
import kotlinx.android.synthetic.main.fragment_store_list.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class StoreListFragment private constructor() : Fragment(R.layout.fragment_store_list) {
    val viewModel: StoreListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()
    }

    private fun setupRecycleView() {
        val listAdapter = StoreListAdapter()
        viewModel.storeList.observe(viewLifecycleOwner,
            Observer { list -> listAdapter.submitList(list) } )

        fragment_store_list_recycle_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }

    interface StoreListClickListener {
        fun onClick(storeListItem: StoreListItem) {

        }
    }
    companion object {
        fun newInstance() =
            StoreListFragment()
    }
}