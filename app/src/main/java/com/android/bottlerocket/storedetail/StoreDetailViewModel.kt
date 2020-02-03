package com.android.bottlerocket.storedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store

class StoreDetailViewModel(private val storeRepository: StoreRepository) : ViewModel() {
    fun getStore(storeId: Int): LiveData<Store> = storeRepository.getStoreById(storeId)
}