package com.android.bottlerocket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bottlerocket.storelist.StoreListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_main_container, StoreListFragment())
            .commit()
    }
}