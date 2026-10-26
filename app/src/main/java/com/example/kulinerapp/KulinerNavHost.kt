package com.example.kulinerapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun KulinerNavHost(
    navController: NavHostController = rememberNavController()
) {
    val kulinerList = remember { mutableStateListOf(*dummyKulinerList.toTypedArray()) }

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            HomeScreen(
                kulinerList = kulinerList,
                onItemClick = { id -> navController.navigate(Screen.Detail(kulinerId = id)) },
                onAddClick = { navController.navigate(Screen.Form) }
            )
        }

        composable<Screen.Detail> { backStackEntry ->
            val route: Screen.Detail = backStackEntry.toRoute()
            val selectedKuliner = kulinerList.find { it.id == route.kulinerId }

            DetailScreen(
                kuliner = selectedKuliner,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<Screen.Form> {
            FormScreen(
                onSaveClick = { nama, lokasi ->
                    val newId = (kulinerList.maxOfOrNull { it.id } ?: 0) + 1
                    kulinerList.add(
                        Kuliner(
                            id = newId,
                            nama = nama,
                            kategori = "Kuliner Baru",
                            harga = 25000,
                            lokasi = lokasi,
                            deskripsi = "Tempat kuliner baru yang ditambahkan via form."
                        )
                    )
                    navController.popBackStack()
                },
                onCancelClick = { navController.popBackStack() }
            )
        }
    }
}