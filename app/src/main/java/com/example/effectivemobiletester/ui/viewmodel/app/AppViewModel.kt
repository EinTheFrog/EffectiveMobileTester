package com.example.effectivemobiletester.ui.viewmodel.app

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletester.ui.navigation.AppDestination
import com.example.effectivemobiletester.ui.navigation.MainDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(): ViewModel() {
    private val _uiState: MutableStateFlow<AppUiState> = MutableStateFlow(AppUiState.Login(false))
    val uiState: StateFlow<AppUiState> = _uiState

    fun switchUiState(newState: AppUiState) {
        _uiState.value = newState
    }
    fun updateLoginTopBarVisibility(visible: Boolean) {
        val currentUiState = _uiState.value
        if (currentUiState is AppUiState.Login) {
            _uiState.value = currentUiState.copy(topBarVisible = visible)
        }
    }

    fun changeMainDestination(destination: MainDestination) {
        val currentUiState = _uiState.value
        if (currentUiState is AppUiState.Main) {
            _uiState.value = currentUiState.copy(destination = destination)
        }
    }

}