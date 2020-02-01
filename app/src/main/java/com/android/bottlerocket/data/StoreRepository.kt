package com.android.bottlerocket.data

import androidx.lifecycle.liveData
import com.android.bottlerocket.data.local.StoreDao
import com.android.bottlerocket.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class StoreRepository(
    private val storeDao: StoreDao,
    private val remoteDataSource: RemoteDataSource
) {
    val stores = liveData(Dispatchers.IO) {
        emit(Result.loading())
        val result = remoteDataSource.fetchStores()
        emit(result)
    }
}
