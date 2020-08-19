package com.example.televisionapp.injection

import android.content.Context
import com.example.televisionapp.TelevisionApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: TelevisionApp) {

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext

}