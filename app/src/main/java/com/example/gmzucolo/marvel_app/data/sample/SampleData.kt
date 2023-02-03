package com.example.gmzucolo.marvel_app.data.sample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.ui.components.BottomAppBarItem

val sampleCharacteres = listOf(
    CharacterModelSample(
        id = 1,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 2,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 3,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 4,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 5,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 6,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    ),
    CharacterModelSample(
        id = 7,
        name = LoremIpsum(3).values.first(),
        description = LoremIpsum(20).values.first()
    )
)

val bottomAppBarItems = listOf(
    BottomAppBarItem(
        label = "",
        icon = Icons.Filled.Search
    ),
    BottomAppBarItem(
        label = "",
        icon = Icons.Filled.Favorite
    ),
    BottomAppBarItem(
        label = "",
        icon = Icons.Filled.AccountBox
    )
)