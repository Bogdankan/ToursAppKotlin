package com.bogdankan.toursapp.data.mapper

import com.bogdankan.toursapp.data.remote.dto.TourDto
import com.bogdankan.toursapp.domain.model.Tour

fun TourDto.toDomain(): Tour = Tour(
    id = id,
    title = title,
    description = description,
    resources = resources,        // за потреби витягни з json
    companyName = companyName
)