package com.example.televisionapp.injection

import com.example.televisionapp.client.RetrofitApiClientImplementation
import com.example.televisionapp.repository.ApiRepository
import dagger.Module
import dagger.Provides

@Module
class ApiRepositoryModule {

    @Provides
    fun transactionApiRepository(retrofitApiClientImplementation: RetrofitApiClientImplementation): ApiRepository =
        ApiRepository(retrofitApiClientImplementation)
}