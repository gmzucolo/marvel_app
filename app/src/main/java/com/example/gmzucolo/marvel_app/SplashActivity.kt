package com.example.gmzucolo.marvel_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gmzucolo.marvel_app.R
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme

@SuppressLint("CustomSplashScreen")
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
                val editable by remember {
                    mutableStateOf(true)
                }
                val density = LocalDensity.current
                AnimatedVisibility(visible = editable, enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
                    Image(
                        painter = painterResource(id = R.drawable.marvel_logo_large),
                        contentDescription = "logo marvel"
                    )
                }
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
