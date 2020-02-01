package com.android.bottlerocket.storelist

data class StoreListItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val address: String,
    val phoneNumber: String
)