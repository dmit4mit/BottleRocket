package com.android.bottlerocket.storelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.bottlerocket.common.Result
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store

class StoreListViewModel(storeRepository: StoreRepository) : ViewModel() {
    val storeList: LiveData<Result<List<Store>>> = storeRepository.stores
}