package com.example.gmzucolo.marvel_app.ui.components

import androidx.compose.foundation.clickable
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
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacters
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@Composable
fun CharacterRecycler(
    characters: List<CharacterModelSample>,
    modifier: Modifier,
    onNavigateToDetails: (CharacterModelSample) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        items(characters) { c ->
            ItemComicCard(
                character = c,
                onItemCardClick = { onNavigateToDetails(c) }
            )
        }
    }
}

@Preview
@Composable
fun CharacterRecyclerLightPreview(onCharacterClick: () -> Unit = {}) {
    MarvelappTheme(darkTheme = false) {
        CharacterRecycler(
            characters = sampleCharacters,
            modifier = Modifier.clickable { onCharacterClick() })
    }
}


@Preview
@Composable
fun CharacterRecyclerDarkPreview(onCharacterClick: () -> Unit = {}) {
    MarvelappTheme(darkTheme = true) {
        CharacterRecycler(
            characters = sampleCharacters,
            modifier = Modifier.clickable { onCharacterClick() })
    }
}

