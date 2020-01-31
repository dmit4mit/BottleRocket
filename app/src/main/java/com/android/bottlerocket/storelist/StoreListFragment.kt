package com.android.bottlerocket.storelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.bottlerocket.R
import org.koin.android.ext.android.inject

class StoreListFragment : Fragment(R.layout.fragment_store_list) {
    val viewModel: StoreListViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() =
            StoreListFragment()
    }

}