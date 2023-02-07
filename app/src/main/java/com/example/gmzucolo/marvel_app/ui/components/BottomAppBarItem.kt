package com.example.gmzucolo.marvel_app.ui.components

import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.data.sample.bottomAppBarItems
import com.example.gmzucolo.marvel_app.navigation.AppDestination
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

class BottomAppBarItem(
    val label: String,
    val icon: ImageVector,
    val destination: AppDestination
)

@Composable
fun MarvelBottomBar(
    item: BottomAppBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = emptyList(),
    onItemChange: (BottomAppBarItem) -> Unit = {}
) {
    NavigationBar(modifier) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                icon = { Icon(imageVector = icon, contentDescription = label) },
                label = { Text(text = label) },
                selected = item.label == label,
                onClick = { onItemChange(it) }
            )
        }
    }
}

@Preview
@Composable
fun MarvelBottomBarLightPreview() {
    MarvelappTheme(darkTheme = false) {
        MarvelBottomBar(
            item = bottomAppBarItems.first(),
            items = bottomAppBarItems
        )
    }
}

@Preview
@Composable
fun MarvelBottomBarDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        MarvelBottomBar(
            item = bottomAppBarItems.first(),
            items = bottomAppBarItems
        )
    }
}

