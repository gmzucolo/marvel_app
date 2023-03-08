package com.example.gmzucolo.marvel_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gmzucolo.marvel_app.data.sample.bottomAppBarItems
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacters
import com.example.gmzucolo.marvel_app.navigation.AppDestination
import com.example.gmzucolo.marvel_app.ui.components.BottomAppBarItem
import com.example.gmzucolo.marvel_app.ui.components.MarvelBottomBar
import com.example.gmzucolo.marvel_app.ui.detail.DetailCharacterScreen
import com.example.gmzucolo.marvel_app.ui.favorite.FavoriteScreen
import com.example.gmzucolo.marvel_app.ui.list.ListCharacterScreen
import com.example.gmzucolo.marvel_app.ui.list.MarvelCharacterScreen
import com.example.gmzucolo.marvel_app.ui.search.SearchCharacterScreen
import com.example.gmzucolo.marvel_app.ui.theme.MarvelappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntryAsState?.destination
            MarvelappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedItem by remember(currentDestination) {
                        val item = currentDestination?.let {
                            bottomAppBarItems.find {
                                it.destination.route == currentDestination.route
                            }
                        } ?: bottomAppBarItems.first()
                        mutableStateOf(item)
                    }
                    MarvelApp(
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = {
                            val route = it.destination.route
                            navController.navigate(route) {
                                launchSingleTop = true
                                popUpTo(route)
                            }
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = AppDestination.Home.route
                        ) {
//                            composable(AppDestination.Splash.route) {
//                                SplashScreen()
//                                LaunchedEffect(Unit) {
//                                    delay(5000L)
//                                    navController.navigate(AppDestination.Search.route)
//                                }
//                            }
                            composable(AppDestination.Home.route) {
                                MarvelCharacterScreen(viewModel())
//                                ListCharacterScreen(
//                                    characters = ListCharacterViewModel().list,
//                                    onNavigateToDetails = { character ->
//                                        navController.navigate(
//                                            "${AppDestination.Detail.route}/${character.id}"
//                                        )
//                                    }
//                                )
                            }
                            composable(AppDestination.Search.route) {
//                                SearchCharacterScreen(
//                                    characters = sampleCharacters,
//                                    onNavigateToDetails = { character ->
//                                        navController.navigate(
//                                            "${AppDestination.Detail.route}/${character.id}"
//                                        )
//                                    }
//                                )
                            }
                            composable(AppDestination.Favorite.route) {
                                FavoriteScreen()
                            }
                            composable("${AppDestination.Detail.route}/{characterId}") { backStackEntry ->
                                val id = backStackEntry.arguments?.getString("characterId")
                                sampleCharacters.find {
                                    it.id == id
                                }?.let { character ->
                                    DetailCharacterScreen(
                                        character = character,
                                        onFavoriteClick = { navController.navigate(AppDestination.Favorite.route) })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Marvel Characters") },
            )
        },
        bottomBar = {
            MarvelBottomBar(
                item = bottomAppBarItemSelected,
                items = bottomAppBarItems,
                onItemChange = onBottomAppBarItemSelectedChange,
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MarvelAppLightPreview() {
    MarvelappTheme(darkTheme = false) {
        Surface {
            MarvelApp {}
        }
    }
}

@Preview
@Composable
fun MarvelAppNightPreview() {
    MarvelappTheme(darkTheme = true) {
        Surface {
            MarvelApp {}
        }
    }
}