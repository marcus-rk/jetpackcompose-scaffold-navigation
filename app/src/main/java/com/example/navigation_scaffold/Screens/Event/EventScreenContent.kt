package com.example.navigation_scaffold.Screens.Event

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigation_scaffold.Composables.BottomBar
import com.example.navigation_scaffold.Composables.TopBar
import com.example.navigation_scaffold.Navigation.EventNavGraph

@Composable
fun EventScreenContent(rootNavHostController: NavHostController) {
    val eventNavController: NavHostController = rememberNavController()
    // Get the current back stack entry as state
    val currentBackStackEntry = eventNavController.currentBackStackEntryAsState().value
    // Check if the current route is not "event-1"
    val showBackButton = currentBackStackEntry?.destination?.route != "event-1"

    Scaffold(
        topBar = {
            TopBar(
                title = "Event",
                showBackButton = showBackButton,
                onBackClick = { eventNavController.popBackStack() })
                 },
        bottomBar = {
            BottomBar(
                currentRoute = "event",
                onHomeClicked = {
                    rootNavHostController.navigate("home")
                    rootNavHostController.popBackStack(
                        route = "event",
                        inclusive = true
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            EventNavGraph(eventNavController = eventNavController)
        }
    }
}
