package com.example.navigation_scaffold.Navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation_scaffold.Screens.LoginScreen
import com.example.navigation_scaffold.Screens.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(rootNavHostController: NavHostController) {
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
        RegisterScreen(
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