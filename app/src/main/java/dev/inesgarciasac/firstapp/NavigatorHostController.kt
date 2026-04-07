package dev.inesgarciasac.firstapp

import android.transition.Slide
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.inesgarciasac.firstapp.screens.AddScreen
import dev.inesgarciasac.firstapp.screens.ContactScreen
import dev.inesgarciasac.firstapp.screens.HomeScreen

@Composable
fun NavigatorHostController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        //Listo todas las pantallas que tengo
        composable(route = Screens.HomeScreen.name) { HomeScreen(navController) }
        composable(route = Screens.AddScreen.name) { AddScreen(navController) }

        //Envio de parametro
        composable(
            //route = "contact/{userName}", parametro obligatorio
            route = "${Screens.ContactScreen.name}?userName={userName}",
            arguments = listOf(
                navArgument(
                    "userName"
                ) {
                    //type = NavType.StringType
                    defaultValue = "No name"
                })
        ) { stackEntry ->
            val userName = stackEntry.arguments?.getString("userName")

            ContactScreen(navController, userName)
        }
    }
}