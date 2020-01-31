package com.android.bottlerocket.core.di

import com.android.bottlerocket.BuildConfig.SERVER_URL
import com.android.bottlerocket.data.remote.StoreService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
    factory { provideStoreService(get()) }
}

fun provideStoreService(retrofit: Retrofit): StoreService = retrofit.create(StoreService::class.java)

fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder().build()

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

