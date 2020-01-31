package com.android.bottlerocket

import android.app.Activity
import android.os.Bundle
import com.android.bottlerocket.data.remote.StoreService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : Activity() {
    val storeService: StoreService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            Timber.d(storeService.getStores().toString())
        }
    }
}