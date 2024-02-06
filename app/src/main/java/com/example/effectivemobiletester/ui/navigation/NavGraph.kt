package com.example.effectivemobiletester.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletester.ui.composable.login.LoginScreen
import com.example.effectivemobiletester.ui.composable.main.MainScreen
import com.example.effectivemobiletester.ui.viewmodel.login.LoginViewModel
import com.example.effectivemobiletester.ui.viewmodel.main.MainViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LOGIN.route
    ) {
        composable(Destination.LOGIN.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                viewModel = viewModel,
                navigateToMain = { navController.navigate(Destination.MAIN.route) {
                    popUpTo(Destination.LOGIN.route) {
                        inclusive = true
                    }
                } },
            )
        }
        composable(Destination.MAIN.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = viewModel)
        }
    }
}