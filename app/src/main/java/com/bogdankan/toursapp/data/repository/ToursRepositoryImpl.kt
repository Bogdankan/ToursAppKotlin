package com.bogdankan.toursapp.data.repository

import com.bogdankan.toursapp.data.mapper.toDomain
import com.bogdankan.toursapp.data.remote.api.ToursApi
import com.bogdankan.toursapp.domain.model.Tour
import com.bogdankan.toursapp.domain.repo.ToursRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToursRepositoryImpl(
    private val api: ToursApi
) : ToursRepository {

    override suspend fun getAllTours(): Result<List<Tour>> = withContext(Dispatchers.IO) {
        runCatching { api.getAllTours().map { it.toDomain() } }
    }
}