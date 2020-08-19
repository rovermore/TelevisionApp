package com.example.televisionapp.model

data class Movie(
    val name: String?,
    val description: String?,
    val externalId: String?,
    val year: Int?,
    val attachments: List<Attachments>?
) {

}
