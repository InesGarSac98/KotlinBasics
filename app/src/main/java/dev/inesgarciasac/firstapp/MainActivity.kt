package dev.inesgarciasac.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.inesgarciasac.firstapp.layouts.ScaffoldLayout
import dev.inesgarciasac.firstapp.screens.AddScreen
import dev.inesgarciasac.firstapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                //Listo todas las pantallas que tengo
                composable(route = "home") { HomeScreen(navController) }
                composable(route = "add") { AddScreen() }
            }
        }
    }
}
