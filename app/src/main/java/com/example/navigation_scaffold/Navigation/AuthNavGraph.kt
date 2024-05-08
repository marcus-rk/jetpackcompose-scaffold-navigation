package com.example.navigation_scaffold.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation_scaffold.Composables.BottomBar
import com.example.navigation_scaffold.Composables.TopBar
import com.example.navigation_scaffold.Screens.LoginScreen
import com.example.navigation_scaffold.Screens.RegisterScreen

fun NavGraphBuilder.authNavGraph(rootNavHostController: NavHostController) {
    composable("auth-login") {
        LoginScreen(
            onLoginClicked = {
                rootNavHostController.popBackStack(
                    route = "auth",
                    inclusive = true
                )
                rootNavHostController.navigate("home")
            },
            onRegisterClicked = { rootNavHostController.navigate("auth-register") }
        )
    }
    composable("auth-register") {
        Scaffold(
            topBar = {
                TopBar(title = "Register", showBackButton = true, onBackClick = { rootNavHostController.popBackStack() }, onProfileClick = { rootNavHostController.navigate("profile")}, isRegister = true)
            },
            bottomBar = {
                BottomBar() {
                    rootNavHostController.popBackStack(
                        route = "auth",
                        inclusive = true
                    )
                    rootNavHostController.navigate("home")
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Handle button click */ }
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) { scaffoldPadding ->
            RegisterScreen(
                modifier = Modifier.padding(scaffoldPadding),
                onLoginClicked = {
                    rootNavHostController.popBackStack(
                        route = "auth",
                        inclusive = true
                    )
                    rootNavHostController.navigate("home")
                }
            )
        }
    }
}