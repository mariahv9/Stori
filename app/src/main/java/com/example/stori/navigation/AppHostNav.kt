package com.example.stori.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppHostNav(
    navController: NavHostController = rememberNavController(),
    startDestination: String = SplashDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        splashGraph(navController)

        loginGraph(
            navController = navController
        ) { navController.popBackStack(LoginDestination.route, false) }
    }
}
