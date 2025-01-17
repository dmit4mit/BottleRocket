package com.android.bottlerocket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bottlerocket.storelist.StoreListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_main_content, StoreListFragment.newInstance())
            .commit()
    }
}