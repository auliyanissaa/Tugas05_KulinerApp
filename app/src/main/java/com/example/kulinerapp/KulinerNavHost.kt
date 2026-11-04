package com.example.kulinerapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.kulinerapp.ui.CatalogViewModel
import com.example.kulinerapp.ui.DetailScreen
import com.example.kulinerapp.ui.FormScreen
import com.example.kulinerapp.ui.HomeScreen

@Composable
fun KulinerNavHost(
    navController: NavHostController,
    viewModel: CatalogViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        // 1. Home Destination
        composable<Screen.Home> {
            HomeScreen(
                uiState = uiState,
                onKulinerClick = { kulinerId ->
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
            val selectedKuliner = uiState.kulinerList.find { it.id == route.kulinerId }

            DetailScreen(
                kuliner = selectedKuliner,
                onBackClick = { navController.popBackStack() }
            )
        }

        // 3. Form Destination
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