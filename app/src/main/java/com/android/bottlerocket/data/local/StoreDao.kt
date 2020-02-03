package com.android.bottlerocket.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.bottlerocket.data.model.Store

@Dao
interface StoreDao {
    @Query("SELECT * FROM store")
    fun getAll(): LiveData<List<Store>>

    @Query("SELECT * FROM store WHERE store_id == :storeId")
    fun getById(storeId: Int): LiveData<Store>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stores: List<Store>)
}