package com.example.gmzucolo.marvel_app.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmzucolo.marvel_app.ui.theme.AppCustomTypography
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelappTheme {
                SplashScreen()
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Column(
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "MARVEL",
                    style = AppCustomTypography.h1,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 48.sp

                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        SplashScreen()
    }
}

@Preview
@Composable
fun SplashScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        SplashScreen()
    }
}
