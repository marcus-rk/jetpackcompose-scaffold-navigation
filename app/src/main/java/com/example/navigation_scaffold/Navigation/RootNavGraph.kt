package com.example.navigation_scaffold.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.navigation_scaffold.Composables.BottomBar
import com.example.navigation_scaffold.Composables.TopBar
import com.example.navigation_scaffold.Screens.Event.EventScreenContent
import com.example.navigation_scaffold.Screens.HomeScreen
import com.example.navigation_scaffold.Screens.ProfileScreen
import com.example.navigation_scaffold.Screens.RegisterScreen

@Composable
fun RootNavGraph() {
    val rootNavHostController: NavHostController = rememberNavController()

    NavHost(navController = rootNavHostController, startDestination = "auth") {
        navigation(route = "auth", startDestination = "auth-login") {
            authNavGraph(rootNavHostController = rootNavHostController)
        }
        composable(route = "home") {
            HomeScreen(onNavigateToEvent = {
                rootNavHostController.popBackStack(route = "home", inclusive = false)
                rootNavHostController.navigate("event") })
        }
        composable(route = "event") {
            EventScreenContent(rootNavHostController)
        }
        composable(route = "profile") {
            Scaffold(
                bottomBar = {
                    BottomBar() {
                        rootNavHostController.popBackStack(
                            route = "auth",
                            inclusive = true
                        )
                        rootNavHostController.navigate("home")
                    }
                }) { scaffoldPadding ->
                ProfileScreen(Modifier.padding(scaffoldPadding))
            }
        }
    }
}
