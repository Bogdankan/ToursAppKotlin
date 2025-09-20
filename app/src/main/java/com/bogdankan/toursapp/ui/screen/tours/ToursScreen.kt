package com.bogdankan.toursapp.ui.screen.tours

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bogdankan.toursapp.ui.components.TourCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToursScreen(
    vm: ToursViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Екскурсії") }) }
    ) { innerPadding ->

        when (val s = state) {
            is ToursState.Loading -> Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(Modifier.padding(24.dp))
            }

            is ToursState.Error -> Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(Modifier.padding(24.dp)) {
                    Text("Помилка: ${s.message}")
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = { vm.refresh() }) { Text("Повторити") }
                }
            }

            is ToursState.Data -> LazyColumn(
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(s.items, key = { it.id }) { tour ->
                    TourCard(tour = tour)
                }
            }
        }
    }
}
