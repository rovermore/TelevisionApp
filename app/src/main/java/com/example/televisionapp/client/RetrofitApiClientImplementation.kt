package com.example.televisionapp.client

import com.example.televisionapp.model.CatalogResponse
import com.example.televisionapp.model.DetailResponse
import javax.inject.Inject

class RetrofitApiClientImplementation
    @Inject constructor(private val retrofitApiClient: RetrofitApiClient):
    RetrofitApiClient {

    override suspend fun getCatalogResponse(): CatalogResponse {
        return retrofitApiClient.getCatalogResponse()
    }

    override suspend fun getDetailResponse(movieId: String): DetailResponse {
        return retrofitApiClient.getDetailResponse(movieId)
    }
}