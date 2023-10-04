package com.example.restapimvvm

import android.app.Application
import com.example.restapimvvm.di.ApplicationDiComponent
import com.example.restapimvvm.di.DaggerApplicationDiComponent

class MyApplication : Application() {

    lateinit var applicationDiComponent : ApplicationDiComponent
    override fun onCreate() {
        super.onCreate()

        applicationDiComponent = DaggerApplicationDiComponent.builder().build()
    }
}