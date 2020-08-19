package com.example.televisionapp.model

import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("response")
    val catalogList: List<Movie>?
) {
}