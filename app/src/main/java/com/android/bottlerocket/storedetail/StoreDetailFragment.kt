package com.android.bottlerocket.storedetail

import androidx.fragment.app.Fragment
import com.android.bottlerocket.storelist.StoreListFragment

class StoreDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            StoreListFragment()
    }
}