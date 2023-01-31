package com.example.gmzucolo.marvel_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.gmzucolo.marvel_app.R
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemComicCard() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { }) {
            Image(
                painter = painterResource(id = R.drawable.marvel_logo_large),
                contentDescription = "", modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Name", modifier = Modifier.padding(vertical = 8.dp))
            Text(text = LoremIpsum(20).values.first())
        }
    }
}

@Preview
@Composable
fun ItemComicCardLightPreview() {
    MarvelappTheme(darkTheme = false) {
        ItemComicCard()
    }
}

@Preview
@Composable
fun ItemComicCardDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        ItemComicCard()
    }
}