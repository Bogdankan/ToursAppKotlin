package com.bogdankan.toursapp.data.remote.api

import com.bogdankan.toursapp.data.remote.dto.TourDto
import retrofit2.Response
import retrofit2.http.GET

interface ToursApi {
    @GET("/api/Tours")
    suspend fun getAllTours(): List<TourDto>

    @GET("/api/Tours/{id}")
    suspend fun getTourById(): TourDto
}