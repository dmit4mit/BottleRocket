package com.android.bottlerocket.core.di

import android.content.Context
import androidx.room.Room
import com.android.bottlerocket.data.StoreRepository
import com.android.bottlerocket.data.local.AppDatabase
import com.android.bottlerocket.data.local.StoreDao
import com.android.bottlerocket.data.remote.RemoteDataSource
import com.android.bottlerocket.data.remote.StoreService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { provideAppDatabase(androidContext()) }
    single { provideRemoteDataSource(get()) }
    single { provideStoreDao(get()) }
    single { provideStoreRepository(get(), get()) }
}

fun provideRemoteDataSource(storeService: StoreService) = RemoteDataSource(storeService)

fun provideStoreDao(appDatabase: AppDatabase) = appDatabase.storeDao()

fun provideAppDatabase(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, "bottle-rocket-database").build()

fun provideStoreRepository(storeDao: StoreDao, remoteDataSource: RemoteDataSource) =
    StoreRepository(storeDao, remoteDataSource)

