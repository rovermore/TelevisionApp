package com.example.televisionapp.injection

import com.example.televisionapp.repository.ApiRepository
import com.example.televisionapp.usecase.CatalogListUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getCatalogListUseCase(repository: ApiRepository): CatalogListUseCase =
        CatalogListUseCase(repository)
}