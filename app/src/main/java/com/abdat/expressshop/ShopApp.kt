package com.abdat.expressshop

import android.app.Application
import com.abdat.expressshop.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ShopApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShopApp)
            modules(appModule)
        }

    }
}