package com.example.gmzucolo.marvel_app.ui.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacteres
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
fun SearchCharacterScreen() {
    Column() {
        SearchTextField(searchText = "", onSearchTextChange = {})
        CharacterRecycler(characters = sampleCharacteres)
    }
}

@Preview
@Composable
fun SearchCharacterScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        SearchCharacterScreen()
    }
}

@Preview
@Composable
fun SearchCharacterScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        SearchCharacterScreen()
    }
}