package com.example.televisionapp.usecase

interface UseCaseWithParameter {
    suspend fun requestWithParameter(parameter: String): Any
}