package com.bogdankan.toursapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bogdankan.toursapp.ui.screen.tours.ToursScreen

object Routes { const val TOURS = "tours" }

@Composable
fun AppNavHost() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Routes.TOURS) {
        composable(Routes.TOURS) { ToursScreen() }
    }
}