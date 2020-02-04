package com.android.bottlerocket.storedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.bottlerocket.databinding.FragmentDetailStoreBinding
import org.koin.android.viewmodel.ext.android.viewModel

class StoreDetailFragment : Fragment() {
    private val viewModel: StoreDetailViewModel by viewModel()
    private lateinit var binding: FragmentDetailStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailStoreBinding.inflate(inflater, container, false)
        val storeId = arguments?.getInt(STORE_ID_KEY)!!
        binding.apply {
            lifecycleOwner = this@StoreDetailFragment
            store = viewModel.getStore(storeId)
        }
        binding.executePendingBindings()

        return binding.root
    }

    companion object {
        const val STORE_ID_KEY = "storeId"

        fun newInstance(storeId: Int) = StoreDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(STORE_ID_KEY, storeId)
            }
        }
    }
}