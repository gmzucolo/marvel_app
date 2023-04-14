package com.example.gmzucolo.marvel_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModel
import com.example.gmzucolo.marvel_app.ui.components.SearchTextField
import com.example.gmzucolo.marvel_app.ui.viewmodels.SearchCharacterViewModel
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@Composable
fun SearchCharacterScreen(
    viewModel: SearchCharacterViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onNavigateToDetails: (CharacterModel) -> Unit = {}
) {
    val searchQuery = remember { mutableStateOf("") }
    val searchResult = viewModel.searchCharacter.collectAsState()

    Column() {
        SearchTextField(
            searchText = searchQuery.value,
            onSearchTextChange = { searchQuery.value = it },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            searchResult.value.data?.data?.let { it ->
                items(it.results) { character ->
                    character.let {
                        CharacterItem(it)
                    }
                }
            }
        }
        LaunchedEffect(searchQuery.value) {
            viewModel.fetch(searchQuery.value)
        }
    }
}

@Composable
private fun CharacterItem(
    character: CharacterModel
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val thumbnail = character.thumbnailModel
        Image(
            painter = rememberAsyncImagePainter(
                "${thumbnail.pathSec}.${thumbnail.extension}"
            ),
            contentDescription = null,
            modifier = Modifier.size(144.dp, 144.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineLarge
        )
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