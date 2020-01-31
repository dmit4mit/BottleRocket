package com.android.bottlerocket.data.model

data class Store(
    val storeID: Int,
    val name: String,
    val storeLogoUrl: String,
    val zipcode: Int,
    val address: String,
    val state: String,
    val city: String,
    val latitude: String,
    val longitude: String,
    val phone: String
)

data class StoreList(
    val stores: List<Store>
)