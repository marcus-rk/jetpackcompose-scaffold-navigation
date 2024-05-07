package com.example.navigation_scaffold.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.navigation_scaffold.Screens.Event.EventScreenContent
import com.example.navigation_scaffold.Screens.HomeScreen
import com.example.navigation_scaffold.Screens.ProfileScreen

@Composable
fun RootNavGraph() {
    val rootNavHostController: NavHostController = rememberNavController()

    NavHost(navController = rootNavHostController, startDestination = "auth") {
        navigation(route = "auth", startDestination = "auth-login") {
            AuthNavGraph(rootNavHostController = rootNavHostController)
        }
        composable(route = "home") {
            HomeScreen(onNavigateToEvent = {
                rootNavHostController.popBackStack(
                    route = "home",
                    inclusive = false
                )
                rootNavHostController.navigate("event") })
        }
        composable(route = "event") {
            EventScreenContent(rootNavHostController)
        }
        composable(route = "profile") {
            ProfileScreen()
        }
    }
}
