package com.example.gmzucolo.marvel_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
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
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                "${comic.thumbnailModel.path}.${comic.thumbnailModel.extension}"
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

@Preview
@Composable
fun DetailCharacterScreenLightPreview() {
}

@Preview
@Composable
fun DetailCharacterScreenDarkPreview() {

}