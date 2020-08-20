package com.example.televisionapp.repository

import com.example.televisionapp.model.CatalogResponse
import com.example.televisionapp.model.DetailResponse

interface Repository {

    suspend fun getCatalogResponse(): CatalogResponse

    suspend fun getDetailResponse(movieId: String): DetailResponse
}