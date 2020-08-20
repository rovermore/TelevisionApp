package com.example.televisionapp.client

import com.example.televisionapp.model.CatalogResponse
import com.example.televisionapp.model.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApiClient {

    @GET("GetUnifiedList?client=json&statuses=published&definitions=SD;HD;4K&external_category_id=SED_3880&filter_empty_categories=true")
    suspend fun getCatalogResponse()
            : CatalogResponse

    @GET("GetVideo?client=json")
    suspend fun getDetailResponse(@Query("external_id") movieId: String)
            : DetailResponse
}