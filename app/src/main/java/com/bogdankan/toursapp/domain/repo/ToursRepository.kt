package com.bogdankan.toursapp.domain.repo

import com.bogdankan.toursapp.domain.model.Tour
import retrofit2.Response
import retrofit2.http.GET

interface ToursRepository {
    suspend fun getAllTours(): Result<List<Tour>>
}