package com.example.gmzucolo.marvel_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val lightThemeColors: ColorScheme
    @Composable get() = lightColorScheme(
        primary = Color(0xFFB62411),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFFFDAD4),
        onPrimaryContainer = Color(0xFF400200),
        secondary = Color(0xFF4753BE),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFDFE0FF),
        onSecondaryContainer = Color(0xFF000865),
        tertiary = Color(0xFF845400),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFFFDDB6),
        onTertiaryContainer = Color(0xFF2A1800),
        error = Color(0xFFBA1A1A),
        errorContainer = Color(0xFFFFDAD6),
        onError = Color(0xFFFFFFFF),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFFFFBFF),
        onBackground = Color(0xFF3C002C),
        surface = Color(0xFFFFFBFF),
        onSurface = Color(0xFF3C002C),
        surfaceVariant = Color(0xFFF5DDD9),
        onSurfaceVariant = Color(0xFF534340),
        outline = Color(0xFF857370),
        inverseOnSurface = Color(0xFFFFECF3),
        inverseSurface = Color(0xFF5A1145),
        inversePrimary = Color(0xFFFFB4A7)
    )

private val DarkThemeColors: ColorScheme
    @Composable get() = darkColorScheme(
        primary = Color(0xFFFFB4A7),
        onPrimary = Color(0xFF670600),
        primaryContainer = Color(0xFF910B00),
        onPrimaryContainer = Color(0xFFFFDAD4),
        secondary = Color(0xFFBDC2FF),
        onSecondary = Color(0xFF101D8F),
        secondaryContainer = Color(0xFFDFE0FF),
        onSecondaryContainer = Color(0xFF2D39A5),
        tertiary = Color(0xFFFFB95A),
        onTertiary = Color(0xFF462A00),
        tertiaryContainer = Color(0xFF643F00),
        onTertiaryContainer = Color(0xFFFFDDB6),
        error = Color(0xFFFFB4AB),
        errorContainer = Color(0xFF93000A),
        onError = Color(0xFF690005),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF3C002C),
        onBackground = Color(0xFFFFD8EB),
        surface = Color(0xFF3C002C),
        onSurface = Color(0xFFFFD8EB),
        surfaceVariant = Color(0xFF534340),
        onSurfaceVariant = Color(0xFFD8C2BE),
        outline = Color(0xFFA08C89),
        inverseOnSurface = Color(0xFF3C002C),
        inverseSurface = Color(0xFFFFD8EB),
        inversePrimary = Color(0xFFB62411)
    )

@Composable
fun MarvelappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) DarkThemeColors else lightThemeColors
        }
        darkTheme -> DarkThemeColors
        else -> lightThemeColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Preview
@Composable
fun LightColorsPreview() {
    MarvelappTheme(darkTheme = false) {
        ColorList()
    }
}

@Preview
@Composable
fun DarkColorsPreview() {
    MarvelappTheme(darkTheme = true) {
        ColorList()
    }
}

@Composable
fun ColorList() {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxHeight()
    ) {
        mapOf(
            "primary" to MaterialTheme.colorScheme.primary,
            "primaryVariant" to MaterialTheme.colorScheme.primaryContainer,
            "primarySurface" to MaterialTheme.colorScheme.onPrimaryContainer,
            "onPrimary" to MaterialTheme.colorScheme.onPrimary,
            "inversePrimary" to MaterialTheme.colorScheme.inversePrimary,

            "secondary" to MaterialTheme.colorScheme.secondary,
            "onSecondary" to MaterialTheme.colorScheme.onSecondary,
            "secondaryVariant" to MaterialTheme.colorScheme.secondaryContainer,
            "onSecondaryContainer" to MaterialTheme.colorScheme.onSecondaryContainer,

            "tertiary" to MaterialTheme.colorScheme.tertiary,
            "onTertiary" to MaterialTheme.colorScheme.onTertiary,
            "tertiaryContainer" to MaterialTheme.colorScheme.tertiaryContainer,
            "onTertiaryContainer" to MaterialTheme.colorScheme.onTertiaryContainer,

            "background" to MaterialTheme.colorScheme.background,
            "onBackground" to MaterialTheme.colorScheme.onBackground,

            "surface" to MaterialTheme.colorScheme.surface,
            "onSurface" to MaterialTheme.colorScheme.onSurface,
            "surfaceVariant" to MaterialTheme.colorScheme.surfaceVariant,
            "onSurfaceVariant" to MaterialTheme.colorScheme.onSurfaceVariant,
            "surfaceTint" to MaterialTheme.colorScheme.surfaceTint,
            "inverseSurface" to MaterialTheme.colorScheme.inverseSurface,
            "inverseOnSurface" to MaterialTheme.colorScheme.inverseOnSurface,

            "error" to MaterialTheme.colorScheme.error,
            "onError" to MaterialTheme.colorScheme.onError,
            "errorContainer" to MaterialTheme.colorScheme.errorContainer,
            "onErrorContainer" to MaterialTheme.colorScheme.onErrorContainer,
            "outline" to MaterialTheme.colorScheme.outline
        ).forEach { (text, color) ->
            Row() {
                Text(
                    text = text, color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(32.dp)
                        .background(color)
                )
            }
        }
    }
}