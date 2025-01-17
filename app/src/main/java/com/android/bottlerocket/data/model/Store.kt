package com.android.bottlerocket.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Store(
    @PrimaryKey
    @ColumnInfo(name = "store_id")
    val storeID: Int,
    val name: String,
    @ColumnInfo(name = "store_logo_url")
    val storeLogoURL: String,
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