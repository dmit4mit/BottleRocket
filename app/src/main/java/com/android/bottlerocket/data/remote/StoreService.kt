package com.android.bottlerocket.data.remote

import com.android.bottlerocket.data.model.StoreList
import retrofit2.Response
import retrofit2.http.GET

interface StoreService {
    @GET("stores.json")
    suspend fun getStores(): Response<StoreList>
}