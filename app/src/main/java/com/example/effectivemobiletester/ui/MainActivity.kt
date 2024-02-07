package com.example.effectivemobiletester.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletester.ui.composable.login.LoginScreen
import com.example.effectivemobiletester.ui.composable.topBar.EMBottomBar
import com.example.effectivemobiletester.ui.composable.topBar.EMTopBar
import com.example.effectivemobiletester.ui.navigation.MainDestination
import com.example.effectivemobiletester.ui.navigation.NavGraph
import com.example.effectivemobiletester.ui.theme.EffectiveMobileTesterTheme
import com.example.effectivemobiletester.ui.viewmodel.app.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveMobileTesterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val appViewModel = hiltViewModel<AppViewModel>()
                    val appUiState by appViewModel.uiState.collectAsState()
                    Scaffold(
                        topBar = { EMTopBar(appUiState = appUiState) },
                        bottomBar = { EMBottomBar(
                            appUiState = appUiState,
                            navigate = { route ->
                                appViewModel.changeMainDestination(
                                    destination = MainDestination.getByRoute(route)
                                )
                                navController.navigate(route)
                            }
                        ) }
                    ) { paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues)) {
                            NavGraph(
                                appViewModel = appViewModel,
                                navController = navController,
                            )
                        }
                    }
                }
            }
        }
    }
}