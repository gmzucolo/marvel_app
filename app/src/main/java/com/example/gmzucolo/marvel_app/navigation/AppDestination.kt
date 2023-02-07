package com.example.gmzucolo.marvel_app.navigation

sealed class AppDestination(val route: String) {
    object Search : AppDestination("search")
    object Detail : AppDestination("detail")
    object Favorite : AppDestination("favorite")
}