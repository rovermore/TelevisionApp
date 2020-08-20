package com.example.televisionapp.usecase

import com.example.televisionapp.model.CatalogResponse
import com.example.televisionapp.repository.ApiRepository
import javax.inject.Inject

class CatalogListUseCase
    @Inject constructor(private val repository: ApiRepository): UseCase {

    override suspend fun request(): CatalogResponse{
        return repository.getCatalogResponse()
    }
}