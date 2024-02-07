package com.example.effectivemobiletester.ui.viewmodel.app

import com.example.effectivemobiletester.ui.navigation.MainDestination

sealed interface AppUiState {

    data class Login(val topBarVisible: Boolean): AppUiState

    data class Main(
        val destination: MainDestination = MainDestination.MAIN,
    ): AppUiState
}