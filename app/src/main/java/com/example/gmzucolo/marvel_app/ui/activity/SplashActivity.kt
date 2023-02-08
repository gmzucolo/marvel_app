package com.example.gmzucolo.marvel_app.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gmzucolo.marvel_app.R
import com.example.gmzucolo.marvel_app.navigation.AppDestination
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme
import kotlinx.coroutines.delay

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
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(AppDestination.Search.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .alpha(alpha = alpha),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel_logo_large),
            contentDescription = "logo marvel"
        )
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

@Preview
@Composable
fun AnimatedSplashScreenLightPreview() {
    MarvelappTheme(darkTheme = false) {
        Splash(alpha = 1f)
    }
}

@Preview
@Composable
fun AnimatedSplashScreenDarkPreview() {
    MarvelappTheme(darkTheme = true) {
        Splash(alpha = 1f)
    }
}
