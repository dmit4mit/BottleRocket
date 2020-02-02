package com.android.bottlerocket.storelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bottlerocket.R
import com.android.bottlerocket.data.Result
import com.android.bottlerocket.databinding.FragmentStoreListBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class StoreListFragment : Fragment() {
    val viewModel: StoreListViewModel by viewModel()
    private lateinit var binding: FragmentStoreListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreListBinding.inflate(inflater, container, false)

        val listAdapter = StoreListAdapter()
        subscribeAdapter(listAdapter)
        with(binding.fragmentStoreListRecycleView) {
            addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt()))
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            setHasFixedSize(true)
        }

        return binding.root
    }

    private fun subscribeAdapter(listAdapter: StoreListAdapter) {
        viewModel.storeList.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    listAdapter.submitList(result.data?.stores)
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

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    private fun showProgressBar() {
        binding.fragmentStoreListProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.fragmentStoreListProgressBar.visibility = View.GONE
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