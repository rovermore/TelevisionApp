package com.example.televisionapp.repository

import com.example.televisionapp.client.RetrofitApiClientImplementation
import com.example.televisionapp.model.CatalogResponse
import javax.inject.Inject

class ApiRepository
    @Inject constructor(private val api: RetrofitApiClientImplementation): Repository {

    override suspend fun getTransactionsResponse(): CatalogResponse {
        return api.getTransactionsResponse()

    }
}