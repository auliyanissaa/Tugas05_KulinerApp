package com.example.kulinerapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.kulinerapp.ui.CatalogViewModel
import com.example.kulinerapp.ui.FormScreen

@Composable
fun KulinerNavHost(
    navController: NavHostController,
    viewModel: CatalogViewModel
) {
    // Mengonsumsi state menggunakan lifecycle-aware collection (Standar Pertemuan 6)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        // 1. Home Destination
        composable<Screen.Home> {
            HomeScreen(
                kulinerList = uiState.kulinerList, // Pass the list from uiState
                onItemClick = { kulinerId ->          // Match HomeScreen's onItemClick parameter
                    navController.navigate(Screen.Detail(kulinerId = kulinerId))
                },
                onAddClick = {
                    navController.navigate(Screen.Form)
                }
            )
        }

        // 2. Detail Destination
        composable<Screen.Detail> { backStackEntry ->
            val route: Screen.Detail = backStackEntry.toRoute()
            // Menangani non-happy path / invalid ID sesuai ketentuan tugas
            val selectedKuliner = uiState.kulinerList.find { it.id == route.kulinerId }

            DetailScreen(
                kuliner = selectedKuliner,
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Form Destination (Menerima callback, tanpa memegang NavController langsung di ViewModel)
        composable<Screen.Form> {
            FormScreen(
                onBackClick = { navController.popBackStack() },
                onSaveClick = { nama, lokasi ->
                    viewModel.addKuliner(nama, lokasi)
                    navController.popBackStack()
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}