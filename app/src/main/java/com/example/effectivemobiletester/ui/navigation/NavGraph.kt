package com.example.effectivemobiletester.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletester.ui.composable.login.LoginScreen
import com.example.effectivemobiletester.ui.viewmodel.login.LoginViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LOGIN.route
    ) {
        composable(Destination.LOGIN.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel = viewModel)
        }
        composable(Destination.MAIN.route) {

        }
    }
}