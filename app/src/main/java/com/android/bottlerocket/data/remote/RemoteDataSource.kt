package com.android.bottlerocket.data.remote

import com.android.bottlerocket.common.Result
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception
import java.net.UnknownHostException

class RemoteDataSource(private val storeService: StoreService) {
    suspend fun fetchStores() = makeApiCall { storeService.getStores() }

    private suspend fun <T> makeApiCall(call: suspend () -> Response<T>): Result<T> {
        try {
            with(call.invoke()) {
                if (isSuccessful) {
                    body()?.let { return Result.success(it) }
                }

                val errorMsg = "Network call has failed: ${code()} ${message()}"
                return createErrorResult(null, errorMsg)
            }
        } catch (e: UnknownHostException) {
            return createErrorResult(e, "Unable to load items. Check your internet connection")
        } catch (e: Exception) {
            return createErrorResult(e, e.message ?: "Unable to load items. Unknown error")
        }
    }

    private fun <T> createErrorResult(exception: Exception?, message: String): Result<T> {
        Timber.e(exception)
        return Result.error(message)
    }


}