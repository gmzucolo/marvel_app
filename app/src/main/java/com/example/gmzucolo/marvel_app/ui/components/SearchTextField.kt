package com.example.gmzucolo.marvel_app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme
import com.example.gmzucolo.marvel_app.ui.theme.md_theme_light_error
import com.example.gmzucolo.marvel_app.ui.theme.md_theme_light_shadow

@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = searchText, onValueChange = { newValue ->
            onSearchTextChange(newValue)
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search"
            )
        },
        label = { Text(text = "Item") },
        placeholder = { Text(text = "Tell us your research?") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = md_theme_light_error,
            focusedLabelColor = md_theme_light_error,
            unfocusedBorderColor = md_theme_light_shadow,
            unfocusedLabelColor = md_theme_light_shadow,
            cursorColor = md_theme_light_shadow
        )
    )
}

@Preview
@Composable
fun SearchTextFieldLightPreview() {
    MarvelappTheme(darkTheme = false) {
        SearchTextField(searchText = "test", onSearchTextChange = {})
    }
}

@Preview
@Composable
fun SearchTextFieldDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        SearchTextField(searchText = "test", onSearchTextChange = {})
    }
}