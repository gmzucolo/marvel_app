package com.example.gmzucolo.marvel_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@Composable
fun FavoriteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(text = "Favorite Screen")

    }
}

@Preview
@Composable
fun FavoriteScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        FavoriteScreen()
    }
}

@Preview
@Composable
fun FavoriteScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        FavoriteScreen()
    }
}