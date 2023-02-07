package com.example.gmzucolo.marvel_app.ui.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacters
import com.example.gmzucolo.marvel_app.ui.components.CharacterRecycler
import com.example.gmzucolo.marvel_app.ui.components.SearchTextField
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

class SearchCharacterFragment : ComponentActivity() {
    val viewModel: SearchCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelappTheme() {
                SearchCharacterScreen()
            }
        }
    }
}

@Composable
fun SearchCharacterScreen(
    modifier: Modifier = Modifier,
    characters: List<CharacterModelSample> = emptyList(),
    onNavigateToDetails: () -> Unit = {}
) {
    Column() {
        SearchTextField(
            searchText = "", onSearchTextChange = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
        CharacterRecycler(characters = characters, modifier, onNavigateToDetails)
    }
}

@Preview
@Composable
fun SearchCharacterScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        SearchCharacterScreen(characters = sampleCharacters)
    }
}

@Preview
@Composable
fun SearchCharacterScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        SearchCharacterScreen(characters = sampleCharacters)
    }
}