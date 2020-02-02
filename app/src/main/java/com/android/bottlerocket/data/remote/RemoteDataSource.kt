package com.android.bottlerocket.data.remote

import com.android.bottlerocket.data.Result
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