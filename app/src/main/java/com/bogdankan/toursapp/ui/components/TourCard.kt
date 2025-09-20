package com.bogdankan.toursapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bogdankan.toursapp.domain.model.Tour

@Composable
fun TourCard(tour: Tour, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth(), shape = MaterialTheme.shapes.large) {
        Column(Modifier.padding(12.dp)) {
            if (!tour.resources.isNullOrBlank()) {
                AsyncImage(
                    model = tour.resources,
                    contentDescription = tour.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
                Spacer(Modifier.height(8.dp))
            }
            Text(tour.title, style = MaterialTheme.typography.titleMedium)
            if (!tour.companyName.isNullOrBlank()) {
                Text(tour.companyName!!, style = MaterialTheme.typography.labelMedium)
            }
            Spacer(Modifier.height(6.dp))
            Text(
                tour.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}