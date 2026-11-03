package com.example.kulinerapp.ui

import com.example.kulinerapp.Kuliner

data class CatalogUiState(
    val kulinerList: List<Kuliner> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)