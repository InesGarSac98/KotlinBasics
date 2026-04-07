package dev.inesgarciasac.firstapp

sealed class Screens(
    val name: String
) {
    object HomeScreen: Screens("home")
    object AddScreen: Screens("adduser")
    object ContactScreen: Screens("edit")
}