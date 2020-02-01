package com.android.bottlerocket.storelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.bottlerocket.data.Result
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.data.model.StoreList
import org.koin.core.KoinComponent
import org.koin.core.inject

class StoreListViewModel(storeRepository: StoreRepository) : ViewModel() {
    val storeList: LiveData<Result<StoreList>> = storeRepository.stores
}