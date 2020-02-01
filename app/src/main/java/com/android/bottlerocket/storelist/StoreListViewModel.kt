package com.android.bottlerocket.storelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store
import org.koin.core.KoinComponent
import org.koin.core.inject

class StoreListViewModel(storeRepository: StoreRepository) : ViewModel() {
    val storeList: LiveData<List<Store>> = storeRepository.stores
}