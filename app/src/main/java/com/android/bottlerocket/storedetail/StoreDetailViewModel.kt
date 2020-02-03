package com.android.bottlerocket.storedetail

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import coil.api.load
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.model.Store

class StoreDetailViewModel(private val storeRepository: StoreRepository) : ViewModel() {
    fun getStore(storeId: Int): LiveData<Store> = storeRepository.getStoreById(storeId)
//    fun loadImage(imageView: ImageView, url: String) = imageView.load(url)

}