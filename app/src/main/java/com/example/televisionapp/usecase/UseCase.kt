package com.example.televisionapp.usecase

interface UseCase {

    suspend fun request(): Any
}