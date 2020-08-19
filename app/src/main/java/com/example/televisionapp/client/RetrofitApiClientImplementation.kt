package com.example.televisionapp.client

import com.example.televisionapp.model.CatalogResponse
import javax.inject.Inject

class RetrofitApiClientImplementation
    @Inject constructor(private val retrofitApiClient: RetrofitApiClient):
    RetrofitApiClient {

    override suspend fun getTransactionsResponse(): CatalogResponse {
        return retrofitApiClient.getTransactionsResponse()
    }
}