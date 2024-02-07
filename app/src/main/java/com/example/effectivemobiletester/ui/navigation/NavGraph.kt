package com.example.effectivemobiletester.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletester.ui.composable.login.LoginScreen
import com.example.effectivemobiletester.ui.composable.main.MainScreen
import com.example.effectivemobiletester.ui.viewmodel.app.AppUiState
import com.example.effectivemobiletester.ui.viewmodel.app.AppViewModel
import com.example.effectivemobiletester.ui.viewmodel.login.LoginViewModel
import com.example.effectivemobiletester.ui.viewmodel.main.MainViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    appViewModel: AppViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.LOGIN.route
    ) {
        composable(AppDestination.LOGIN.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                appViewModel = appViewModel,
                viewModel = viewModel,
                navigateToMain = { navController.navigate(AppDestination.MAIN.route) {
                    appViewModel.switchUiState(AppUiState.Main())
                    popUpTo(AppDestination.LOGIN.route) {
                        inclusive = true
                    }
                } },
            )
        }
        navigation(startDestination = MainDestination.MAIN.route, route = AppDestination.MAIN.route) {
            composable(MainDestination.MAIN.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
            composable(MainDestination.CATALOG.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
            composable(MainDestination.CART.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
            composable(MainDestination.DISCOUNTS.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
            composable(MainDestination.PROFILE.route) {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}