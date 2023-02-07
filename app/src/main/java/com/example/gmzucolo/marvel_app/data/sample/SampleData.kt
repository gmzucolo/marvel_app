package com.example.gmzucolo.marvel_app.data.sample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.ui.components.BottomAppBarItem

val sampleCharacters = List(10) { index ->
    CharacterModelSample(
        id = 1,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    )
}

val bottomAppBarItems = listOf(
    BottomAppBarItem(
        label = "Search",
        icon = Icons.Filled.Search,
        route = "search"
    ),
    BottomAppBarItem(
        label = "Favorites",
        icon = Icons.Filled.Favorite,
        route = "favorite"
    ),
    BottomAppBarItem(
        label = "Details",
        icon = Icons.Filled.AccountBox,
        route = "detail"
    )
)