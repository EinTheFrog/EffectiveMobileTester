package com.example.effectivemobiletester.ui.viewmodel.login

import com.example.effectivemobiletester.model.domain.UserDomain

sealed interface LoginUiState {
    data class Default(
        val loading: Boolean = false,
        val error: String? = null,
        val user: UserDomain = UserDomain(
            firstName = "",
            lastName = "",
            phone = "",
        ),
    ) : LoginUiState {

        fun userHasEmptyFields(): Boolean {
            return user.firstName.isEmpty()
                    || user.lastName.isEmpty()
                    || user.phone.isEmpty()
        }
    }

    data object Finished: LoginUiState
}