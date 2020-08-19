package com.example.televisionapp.repository

import com.example.televisionapp.model.CatalogResponse

interface Repository {

    suspend fun getTransactionsResponse(): CatalogResponse
}