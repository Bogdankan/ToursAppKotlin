package com.bogdankan.toursapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TourDto(
    val id: String,
    val title: String,
    val description: String,
    val resources: String? = null,   // наприклад url зображення або json
    val companyName: String? = null
)