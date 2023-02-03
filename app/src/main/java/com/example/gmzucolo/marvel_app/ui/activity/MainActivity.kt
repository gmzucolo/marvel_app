package com.example.gmzucolo.marvel_app.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelappTheme {
                MarvelApp()
            }
        }
    }
}

@Composable
fun MarvelApp() {

}

@Preview(showBackground = true)
@Composable
fun MarvelAppLightPreview() {
    MarvelappTheme(darkTheme = false) {
        MarvelApp()
    }
}

@Preview
@Composable
fun MarvelAppNightPreview() {
    MarvelappTheme(darkTheme = true) {
        MarvelApp()
    }
}