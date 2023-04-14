package com.example.gmzucolo.marvel_app.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@Composable
fun DetailCharacterScreen(
//    character: CharacterModelSample,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
    ) {
//        character.image?.let {
//            AsyncImage(
//                model = character.image,
//                contentDescription = character.description,
//                modifier = Modifier
//                    .height(200.dp)
//                    .fillMaxWidth(),
//                placeholder = painterResource(id = R.drawable.placeholder),
//                contentScale = ContentScale.Crop
//            )
//        }
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            Text(text = character.name, fontSize = 24.sp)
//            character.description?.let { Text(text = it, fontSize = 18.sp) }
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
//        DetailCharacterScreen(character = sampleCharacters.random())
    }
}

@Preview
@Composable
fun DetailCharacterScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
//        DetailCharacterScreen(character = sampleCharacters.random())
    }
}