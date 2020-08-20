package com.example.televisionapp.usecase

import com.example.televisionapp.model.DetailResponse
import com.example.televisionapp.repository.ApiRepository
import javax.inject.Inject

class MovieDetailUseCase
    @Inject constructor(private val repository: ApiRepository): UseCaseWithParameter {

     override suspend fun requestWithParameter(movieId: String): DetailResponse {
        return repository.getDetailResponse(movieId)
    }

}