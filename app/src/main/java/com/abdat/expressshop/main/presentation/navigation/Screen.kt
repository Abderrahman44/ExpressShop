package com.abdat.expressshop.main.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
   data  object HomeScreen : Screen()

    @Serializable
    data object ProfileScreen : Screen()

    @Serializable
    data object CartScreen : Screen()
}