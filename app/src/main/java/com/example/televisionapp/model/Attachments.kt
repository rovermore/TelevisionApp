package com.example.televisionapp.model

data class Attachments(
    val name: String,
    val value: String?
) {
    companion object {
        val BASE_URL: String = "https://smarttv.orangetv.orange.es/stv/api/rtv/v1/images"
    }
}
