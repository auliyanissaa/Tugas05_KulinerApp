package com.example.kulinerapp

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    data class Detail(val kulinerId: Int) : Screen()

    @Serializable
    object Form : Screen()
}