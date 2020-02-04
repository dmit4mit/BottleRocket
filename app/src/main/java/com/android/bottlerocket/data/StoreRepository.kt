package com.android.bottlerocket.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.android.bottlerocket.common.Result
import com.android.bottlerocket.data.local.StoreDao
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class StoreRepository(
    private val storeDao: StoreDao,
    private val remoteDataSource: RemoteDataSource
) {
    val stores = liveData(Dispatchers.IO) {
        emit(Result.loading())

        // get stores from local database and emit
        val databaseSource = storeDao.getAll().map { Result.success(it) }
        emitSource(databaseSource)

        // make network request and save result locally if successful
        val networkResult = remoteDataSource.fetchStores()
        with(networkResult) {
            if (status == Result.Status.SUCCESS) {
                storeDao.insertAll(data!!.stores)
            } else if (status == Result.Status.ERROR) {
                emit(Result.error(message!!))
                emitSource(databaseSource)
            }
        }
    }

    fun getStoreById(storeId: Int): LiveData<Store> = Transformations.map(stores) { result ->
        result.data!!.find { it.storeID == storeId }
    }
}
