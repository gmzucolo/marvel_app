package com.example.gmzucolo.marvel_app.ui.favorite

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteCharacterFragment : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MarvelappTheme {
                FavoriteScreen()
            }
        }
    }
}

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