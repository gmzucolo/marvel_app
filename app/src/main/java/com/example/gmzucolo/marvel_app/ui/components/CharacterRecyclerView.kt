package com.example.gmzucolo.marvel_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacteres
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@Composable
fun CharacterRecycler(
    characters: List<CharacterModelSample>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        items(characters) { c ->
            ItemComicCard(character = c)
        }
    }
}

@Preview
@Composable
fun CharacterRecyclerLightPreview() {
    MarvelappTheme(darkTheme = false) {
        CharacterRecycler(
            characters = sampleCharacteres
        )
    }
}

@Preview
@Composable
fun CharacterRecyclerDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        CharacterRecycler(
            characters = sampleCharacteres
        )
    }
}
