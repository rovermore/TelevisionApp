package com.example.televisionapp.injection

import com.example.televisionapp.client.RetrofitApiClient
import com.example.televisionapp.client.RetrofitApiClientImplementation
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    val BASE_URL: String = "https://smarttv.orangetv.orange.es/stv/api/rtv/v1/"

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        return httpClient.addInterceptor(logging).build()
    }

    @Provides
    fun getRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun transactionRetrofitApiClient(retrofit: Retrofit): RetrofitApiClientImplementation {
        return RetrofitApiClientImplementation(retrofit.create(RetrofitApiClient::class.java))
    }
}