package com.drbrosdev.currencyconverter

import android.app.Application
import com.drbrosdev.currencyconverter.di.appModule
import com.drbrosdev.currencyconverter.di.repoModule
import com.drbrosdev.currencyconverter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}