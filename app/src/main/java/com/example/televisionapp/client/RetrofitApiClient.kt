package com.example.televisionapp.client

import com.example.televisionapp.model.CatalogResponse
import retrofit2.http.GET

interface RetrofitApiClient {

    @GET("GetUnifiedList?client=json&statuses=published&definitions=SD;HD;4K&external_category_id=SED_3880&filter_empty_categories=true")
    suspend fun getTransactionsResponse()
            : CatalogResponse
}