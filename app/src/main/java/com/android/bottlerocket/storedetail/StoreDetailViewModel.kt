package com.android.bottlerocket.storedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store

class StoreDetailViewModel(private val storeRepository: StoreRepository) : ViewModel() {
    private var storeLiveData: LiveData<Store>? = null
    fun getStore(storeId: Int): LiveData<Store> {
        return storeLiveData ?: storeRepository.getStoreById(storeId).also {
            storeLiveData = it
        }
    }
}