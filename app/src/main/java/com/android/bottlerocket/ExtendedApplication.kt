package com.android.bottlerocket

import android.app.Application
import com.android.bottlerocket.core.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class ExtendedApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@ExtendedApplication)
            modules(mainModule)
        }
    }
}