package com.android.bottlerocket.storelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bottlerocket.R
import com.android.bottlerocket.common.MarginItemDecoration
import com.android.bottlerocket.common.Result
import com.android.bottlerocket.databinding.FragmentStoreListBinding
import com.android.bottlerocket.storedetail.StoreDetailFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class StoreListFragment : Fragment(), StoreListAdapter.StoreListClickListener {
    private val viewModel: StoreListViewModel by viewModel()
    private lateinit var binding: FragmentStoreListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreListBinding.inflate(inflater, container, false)

        val listAdapter = StoreListAdapter().apply {
            onItemClickListener = { onStoreItemClick(it) }
        }
        subscribeAdapter(listAdapter)
        with(binding.fragmentStoreListRecycleView) {
            addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt()))
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            setItemViewCacheSize(20)
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onStoreItemClick(storeId: Int) {
        showDetailFragment(storeId)
    }

    private fun subscribeAdapter(listAdapter: StoreListAdapter) {
        viewModel.storeList.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    listAdapter.submitList(result.data)
                    hideProgressBar()
                }
                Result.Status.ERROR -> {
                    showSnackbar(result.message!!)
                    hideProgressBar()
                }

                Result.Status.LOADING -> showProgressBar()
            }
        })
    }

    private fun showDetailFragment(storeId: Int) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_main_content, StoreDetailFragment.newInstance(storeId))
            .addToBackStack(null)
            .commit()
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun showProgressBar() {
        binding.fragmentStoreListProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.fragmentStoreListProgressBar.visibility = View.GONE
    }

    companion object {
        fun newInstance() = StoreListFragment()
    }
}