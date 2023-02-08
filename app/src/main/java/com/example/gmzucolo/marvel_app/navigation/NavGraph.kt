package com.example.gmzucolo.marvel_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gmzucolo.marvel_app.data.sample.sampleCharacters
import com.example.gmzucolo.marvel_app.ui.activity.AnimatedSplashScreen
import com.example.gmzucolo.marvel_app.ui.detail.DetailCharacterScreen
import com.example.gmzucolo.marvel_app.ui.favorite.FavoriteScreen
import com.example.gmzucolo.marvel_app.ui.search.SearchCharacterScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppDestination.Splash.route) {
        composable(AppDestination.Splash.route) {
            AnimatedSplashScreen(navController)
        }
        composable(AppDestination.Search.route) {
            SearchCharacterScreen(
                characters = sampleCharacters,
                onNavigateToDetails = { character ->
                    navController.navigate(
                        "${AppDestination.Detail.route}/${character.id}"
                    )
                }
            )
        }
        composable(AppDestination.Favorite.route) {
            FavoriteScreen()
        }
        composable("${AppDestination.Detail.route}/{characterId}") {
                backStackEntry ->
            val id = backStackEntry.arguments?.getString("characterId")
            sampleCharacters.find {
                it.id == id
            }?.let { character ->
                DetailCharacterScreen(
                    character = character,
                    onFavoriteClick = { navController.navigate(AppDestination.Favorite.route) })
            } ?: LaunchedEffect(Unit) {
                navController.navigateUp()
            }
        }
    }
}