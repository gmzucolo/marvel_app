package com.example.gmzucolo.marvel_app.ui.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.ui.components.CharacterRecycler
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCharacterFragment : ComponentActivity() {
    val viewModel: ListCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelappTheme {
                ListCharacterScreen()
            }
        }
    }
}

@Composable
fun ListCharacterScreen(
    modifier: Modifier = Modifier,
    characters: List<CharacterModelSample> = emptyList(),
    onNavigateToDetails: (CharacterModelSample) -> Unit = {}
) {
    Column() {
        CharacterRecycler(characters = characters, modifier = modifier, onNavigateToDetails)
    }
}

@Preview
@Composable
fun ListCharacterScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        ListCharacterScreen()
    }
}

@Preview
@Composable
fun ListCharacterScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        ListCharacterScreen()
    }
}