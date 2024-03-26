package com.example.stori.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stori.ui.screen.HomeScreen
import com.example.stori.ui.screen.RegisterScreen

object LoginDestination : NavigationDestination {
    override val route: String = "login_route"
    override val destination: String = "login_destination"
}

object RegisterDestination : NavigationDestination {
    override val destination: String = "register_route"
    override val route: String = "register_destination"
}

object HomeDestination : NavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

fun NavGraphBuilder.loginGraph(navController: NavController, onBack: () -> Unit) {
    composable(route = RegisterDestination.route) {
        RegisterScreen(
            onBack = { onBack() },
            onNavigateLogin = {
                navController.popBackStack()
                navController.navigate(LoginDestination.route)
            },
            viewModel = hiltViewModel()
        )
    }

    composable(route = HomeDestination.route) {
        HomeScreen(loginViewModel = hiltViewModel())
    }
}
