package com.android.bottlerocket.core.di

import com.android.bottlerocket.storelist.StoreListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { StoreListViewModel() }
}