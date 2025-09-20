package com.bogdankan.toursapp.domain.usecase

import com.bogdankan.toursapp.domain.model.Tour
import com.bogdankan.toursapp.domain.repo.ToursRepository

class GetAllToursUseCase(private val repo: ToursRepository) {
    suspend operator fun invoke(): Result<List<Tour>> = repo.getAllTours()
}