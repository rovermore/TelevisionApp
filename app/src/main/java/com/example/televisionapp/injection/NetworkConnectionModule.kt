package com.example.televisionapp.injection

import android.content.Context
import com.example.televisionapp.utils.NetworkConnection
import dagger.Module
import dagger.Provides

@Module
class NetworkConnectionModule {

    @Provides
    fun getNetworkConnection(context: Context): NetworkConnection =
        NetworkConnection(context)
}