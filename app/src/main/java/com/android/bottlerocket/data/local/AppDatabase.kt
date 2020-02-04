package com.android.bottlerocket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.bottlerocket.data.model.Store

@Database(entities = [Store::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun storeDao(): StoreDao
}