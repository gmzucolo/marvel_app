package com.example.gmzucolo.marvel_app.navigation

sealed class AppDestination(val route: String) {
    object Home : AppDestination("home")
    object Search : AppDestination("search")
    object Favorite : AppDestination("favorite")
    object Detail : AppDestination("detail")
}