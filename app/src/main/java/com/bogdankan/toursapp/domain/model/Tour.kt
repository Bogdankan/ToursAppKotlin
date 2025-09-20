package com.bogdankan.toursapp.domain.model

data class Tour(
    val id: String,
    val title: String,
    val description: String,
    val resources: String? = null,
    val companyName: String? = null
)