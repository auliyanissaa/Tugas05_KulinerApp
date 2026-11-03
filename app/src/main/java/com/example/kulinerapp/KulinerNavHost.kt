package com.example.kulinerapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.kulinerapp.ui.CatalogViewModel

@Composable
fun KulinerNavHost(
    navController: NavHostController = rememberNavController(),
    viewModel: CatalogViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        // 1. Home Destination
        composable<Screen.Home> {
            HomeScreen(
                kulinerList = uiState.kulinerList,
                onItemClick = { kulinerId ->
                    navController.navigate(Screen.Detail(kulinerId))
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