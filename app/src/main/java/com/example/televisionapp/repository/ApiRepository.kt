package com.example.televisionapp.repository

import com.example.televisionapp.client.RetrofitApiClientImplementation
import com.example.televisionapp.model.CatalogResponse
import com.example.televisionapp.model.DetailResponse
import javax.inject.Inject

class ApiRepository
    @Inject constructor(private val api: RetrofitApiClientImplementation): Repository {

    override suspend fun getCatalogResponse(): CatalogResponse {
        return api.getCatalogResponse()

    }

    override suspend fun getDetailResponse(movieId: String): DetailResponse {
        return api.getDetailResponse(movieId)
    }
}