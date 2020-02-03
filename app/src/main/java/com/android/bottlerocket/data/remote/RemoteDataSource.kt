package com.android.bottlerocket.data.remote

import com.android.bottlerocket.common.Result
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.data.model.StoreList
import retrofit2.Response
import timber.log.Timber

class RemoteDataSource(private val storeService: StoreService) {
    suspend fun fetchStores() = makeApiCall { storeService.getStores() }

    private suspend fun <T> makeApiCall(call: suspend () -> Response<T>): Result<T> =
        with(call.invoke()) {
            if (isSuccessful) {
                body()?.let { return Result.success(it) }
            }

            val errorMsg = "Network call has failed: ${code()} ${message()}"
            Timber.e(errorMsg)
            Result.error(errorMsg)
        }
}