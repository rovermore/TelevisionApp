package com.example.televisionapp.injection

import com.example.televisionapp.MainActivity
import com.example.televisionapp.screen.detail.DetailFragment
import com.example.televisionapp.screen.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        ApiRepositoryModule::class,
        NetworkConnectionModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(detailFragment: DetailFragment)
}