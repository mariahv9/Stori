package com.example.stori.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stori.ui.screen.LoginScreen
import com.example.stori.ui.screen.SplashScreen

object SplashDestination : NavigationDestination {
    override val route: String = "splash_route"
    override val destination: String = "splash_destination"
}

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(SplashDestination.route) {
        SplashScreen(onNavigate = {
            navController.popBackStack()
            navController.navigate(LoginDestination.route)
        })
    }

    composable(LoginDestination.route) {
        LoginScreen(
            viewModel = hiltViewModel(),
            onNavigateRegister = { navController.navigate(RegisterDestination.route) },
            onNavigateHome = { navController.navigate(HomeDestination.route) })
    }
}
