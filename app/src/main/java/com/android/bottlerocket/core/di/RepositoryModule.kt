package com.android.bottlerocket.core.di

import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.local.StoreDao
import com.android.bottlerocket.data.remote.RemoteDataSource
import com.android.bottlerocket.data.remote.StoreService
import org.koin.dsl.module

val repositoryModule = module {
    single { provideStoreRepository(get(), get()) }
    single { StoreDao() }
    single { RemoteDataSource(get()) }
}

fun provideStoreRepository(storeDao: StoreDao, remoteDataSource: RemoteDataSource) =
    StoreRepository(storeDao, remoteDataSource)

