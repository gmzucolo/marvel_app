package com.example.gmzucolo.marvel_app.data.sample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import com.example.gmzucolo.marvel_app.navigation.AppDestination
import com.example.gmzucolo.marvel_app.ui.components.BottomAppBarItem

val bottomAppBarItems = listOf(
    BottomAppBarItem(
        label = "Home",
        icon = Icons.Filled.Home,
        destination = AppDestination.Home
    ),
    BottomAppBarItem(
        label = "Favorites",
        icon = Icons.Filled.Favorite,
        destination = AppDestination.Favorite
    )
)