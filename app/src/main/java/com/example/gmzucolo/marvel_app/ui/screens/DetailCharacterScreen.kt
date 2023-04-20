package com.example.gmzucolo.marvel_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModel
import com.example.gmzucolo.marvel_app.data.model.comic.ComicModel
import com.example.gmzucolo.marvel_app.ui.viewmodels.DetailCharacterViewModel
import com.example.gmzucolo.marvel_app.util.ResourceState

@Composable
fun DetailCharacterScreen(
    characterId: Int,
    viewModel: DetailCharacterViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {}
) {
    val detailsResult = viewModel.details.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetch(characterId)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        when (detailsResult.value) {
            is ResourceState.Success -> {
                val comics = detailsResult.value.data?.data?.results ?: emptyList()
                if (comics.isNotEmpty()) {
                    LazyColumn(modifier = modifier) {
                        items(comics) { comic ->
                            ComicItem(comic)
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "no comics found")
                    }
                }
            }
            is ResourceState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is ResourceState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "error: ${detailsResult.value.message}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ComicItem(comic: ComicModel) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                "${comic.thumbnail.path}.${comic.thumbnail.extension}"
            ),
            contentDescription = null,
            modifier = Modifier.size(72.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = comic.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = comic.description)
        }
    }
}



//        LazyColumn(
//            state = rememberLazyListState(),
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            detailsResult.value.data?.data.let { it ->
//                it?.results?.forEach { character ->
//                    character.let {
//                        CharacterItem(it)
//                    }
//                }
//            }
//        }
//        LaunchedEffect(detailsResult.value) {
//            viewModel.fetch()
//        }
//        detailsResult.value.data?.data.let { details ->
//            Box(
//                modifier = modifier
//                    .fillMaxSize()
//                    .background(MaterialTheme.colorScheme.background)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    // Exiba o nome do personagem
//                    Text(
//                        text = character.name,
//                        style = MaterialTheme.typography.titleMedium
//                    )
//                    // Exiba a descrição do personagem, se houver
//                    character.description?.let { description ->
//                        Text(
//                            text = description,
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                    }
//                    val thumbnail = character.thumbnailModel
//                    Image(
//                        painter = rememberAsyncImagePainter(
//                            "${thumbnail.pathSec}.${thumbnail.extension}"
//                        ),
//                        contentDescription = null,
//                        modifier = Modifier.size(144.dp, 144.dp),
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    // Exiba a lista de URLs relacionados ao personagem, se houver
//                    details.urls?.let { urls ->
//                        Text(
//                            text = "Links:",
//                            style = MaterialTheme.typography.subtitle1
//                        )
//                        Column {
//                            urls.forEach { url ->
//                                Text(
//                                    text = url.type + ": " + url.url,
//                                    style = MaterialTheme.typography.body2
//                                )
//                            }
//                        }
//                }
//            }
//        }
//    }
//}

//@Composable
//private fun CharacterItem(
//    character: CharacterModel,
//    onItemClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .clickable(onClick = onItemClick),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        val thumbnail = character.thumbnailModel
//        Image(
//            painter = rememberAsyncImagePainter(
//                "${thumbnail.pathSec}.${thumbnail.extension}"
//            ),
//            contentDescription = null,
//            modifier = Modifier.size(144.dp, 144.dp),
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(
//            text = character.name,
//            style = MaterialTheme.typography.headlineLarge
//        )
//    }
//}


//@Composable
//fun DetailCharacterScreen(
//    character: CharacterModelSample,
//    modifier: Modifier = Modifier,
//    onFavoriteClick: () -> Unit = {}
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//            .background(MaterialTheme.colorScheme.background)
//    ) {
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
//        Column(
//            Modifier
//                .padding(16.dp)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Text(text = character.name, fontSize = 24.sp)
//            character.description?.let { Text(text = it, fontSize = 18.sp) }
//            Button(
//                onClick = { onFavoriteClick() },
//                Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
//            ) {
//                Text(text = "favorite")
//            }
//        }
//
//    }
//}
//
//@Preview
//@Composable
//fun DetailCharacterScreenLightPreview() {
//    MarvelappTheme(darkTheme = false) {
//        DetailCharacterScreen(character = sampleCharacters.random())
//    }
//}
//
//@Preview
//@Composable
//fun DetailCharacterScreenDarkPreview() {
//    MarvelappTheme(darkTheme = true) {
//        DetailCharacterScreen(character = sampleCharacters.random())
//    }
//}