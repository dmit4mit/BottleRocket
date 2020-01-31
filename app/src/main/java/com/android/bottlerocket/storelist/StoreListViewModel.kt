package com.android.bottlerocket.storelist

import androidx.lifecycle.ViewModel
import com.android.bottlerocket.data.StoreRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class StoreListViewModel : ViewModel(), KoinComponent {
    val storeRepository: StoreRepository by inject()

}