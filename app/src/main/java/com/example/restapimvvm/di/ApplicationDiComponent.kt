package com.example.restapimvvm.di

import com.example.restapimvvm.view.MainActivity
import com.example.restapimvvm.viewmodel.service.MyClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyClient::class])
interface ApplicationDiComponent {

    fun inject(mainActivity: MainActivity)
}