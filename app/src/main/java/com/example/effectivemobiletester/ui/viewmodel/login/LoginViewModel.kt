package com.example.effectivemobiletester.ui.viewmodel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effectivemobiletester.model.domain.UserDomain
import com.example.effectivemobiletester.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
): ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.Default())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun loadCurrentUser() {
        viewModelScope.launch {
            startLoading()
            when(uiState.value) {
                is LoginUiState.Default -> {
                    val currentUser = loadUserFromDatabase()
                    if (currentUser != null) {
                        _uiState.value = LoginUiState.Finished
                    }
                }
                is LoginUiState.Finished -> {}
            }
            finishLoading()
        }
    }

    fun updateUserFirstName(firstName: String) {
        when (val currentState = uiState.value) {
            is LoginUiState.Default -> {
                val oldUserInfo = currentState.user
                val newUserInfo = oldUserInfo.copy(firstName = firstName)
                _uiState.value = currentState.copy(user = newUserInfo)
            }
            is LoginUiState.Finished -> {}
        }
    }

    fun updateUserLastName(lastName: String) {
        when (val currentState = uiState.value) {
            is LoginUiState.Default -> {
                val oldUserInfo = currentState.user
                val newUserInfo = oldUserInfo.copy(lastName = lastName)
                _uiState.value = currentState.copy(user = newUserInfo)
            }
            is LoginUiState.Finished -> {}
        }
    }

    fun updateUserPhone(phone: String) {
        when (val currentState = uiState.value) {
            is LoginUiState.Default -> {
                val oldUserInfo = currentState.user
                val newUserInfo = oldUserInfo.copy(phone = phone)
                _uiState.value = currentState.copy(user = newUserInfo)
            }
            is LoginUiState.Finished -> {}
        }
    }

    private suspend fun loadUserFromDatabase(): UserDomain? {
        val userResult = userRepository.getCurrentUser()
        return if (userResult.isSuccess) {
            val user = userResult.getOrNull()
            user
        } else {
            null
        }
    }

    private fun startLoading() {
        when(val currentUiState = uiState.value) {
            is LoginUiState.Default -> {
                _uiState.value = currentUiState.copy(loading = true)
            }
            is LoginUiState.Finished -> {}
        }
    }

    private fun finishLoading() {
        when(val currentUiState = uiState.value) {
            is LoginUiState.Default -> {
                _uiState.value = currentUiState.copy(loading = false)
            }
            is LoginUiState.Finished -> {}
        }
    }
}