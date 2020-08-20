package com.example.televisionapp.model

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("response")
    val movieDetail: Movie?
)