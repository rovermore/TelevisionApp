package com.example.televisionapp

import android.app.Application
import com.example.televisionapp.injection.*

class TelevisionApp: Application() {

    companion object {
        lateinit var mDaggerAppComponent: AppComponent
        fun daggerAppComponent():AppComponent = mDaggerAppComponent
    }


    override fun onCreate() {
        super.onCreate()
        mDaggerAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule())
            .apiRepositoryModule(ApiRepositoryModule())
            .useCaseModule(UseCaseModule())
            .networkConnectionModule(NetworkConnectionModule())
            .build()

    }
}