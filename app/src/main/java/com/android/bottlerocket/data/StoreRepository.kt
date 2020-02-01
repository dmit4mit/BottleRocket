package com.android.bottlerocket.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.bottlerocket.data.local.StoreDao
import com.android.bottlerocket.data.model.Store
import com.android.bottlerocket.data.remote.StoreService

class StoreRepository(
    storeDao: StoreDao,
    storeService: StoreService
) {
    val storeList = mutableListOf<Store>()
    init {
        for (i in 1..10) {
            val store = Store(1, "Macy's",
                "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/images/macys.jpeg",
                123, "123", "dsad", "dsad",
                "dsad", "dsaksds", "89302932103")
            storeList.add(store)

        }
    }

    val stores: LiveData<List<Store>> = MutableLiveData(storeList)
}
