package com.vast.testmvvm

import android.app.Application
import com.vast.testmvvm.data.di.dataModule
import com.vast.testmvvm.domain.di.domainModule
import com.vast.testmvvm.ui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule
            + domainModule
            + dataModule)
        }
    }
}