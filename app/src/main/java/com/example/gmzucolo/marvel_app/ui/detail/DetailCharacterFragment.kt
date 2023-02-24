package com.example.gmzucolo.marvel_app.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gmzucolo.marvel_app.R
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelSample
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacters
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCharacterFragment : ComponentActivity() {
    val viewModel: DetailCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelappTheme() {
                DetailCharacterScreen(character = sampleCharacters.random())
            }
        }
    }
}

@Composable
fun DetailCharacterScreen(
    character: CharacterModelSample,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
        character.image?.let {
            AsyncImage(
                model = character.image,
                contentDescription = character.description,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = character.name, fontSize = 24.sp)
            character.description?.let { Text(text = it, fontSize = 18.sp) }
            Button(
                onClick = { onFavoriteClick() },
                Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "favorite")
            }
        }

    }
}

@Preview
@Composable
fun DetailCharacterScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        DetailCharacterScreen(character = sampleCharacters.random())
    }
}

@Preview
@Composable
fun DetailCharacterScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        DetailCharacterScreen(character = sampleCharacters.random())
    }
}