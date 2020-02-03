package com.android.bottlerocket.core.di

import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.storedetail.StoreDetailViewModel
import com.android.bottlerocket.storelist.StoreListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { StoreListViewModel(get() as StoreRepository) }
    viewModel { StoreDetailViewModel(get() as StoreRepository) }
}