package com.example.effectivemobiletester.ui.composable.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletester.R
import com.example.effectivemobiletester.ui.composable.common.EMButton
import com.example.effectivemobiletester.ui.composable.common.EMInputField
import com.example.effectivemobiletester.ui.composable.common.EMPhoneInputField
import com.example.effectivemobiletester.ui.theme.EffectiveMobileTesterTheme
import com.example.effectivemobiletester.ui.theme.Paddings
import com.example.effectivemobiletester.ui.viewmodel.app.AppViewModel
import com.example.effectivemobiletester.ui.viewmodel.login.LoginUiState
import com.example.effectivemobiletester.ui.viewmodel.login.LoginViewModel

@Composable
fun LoginScreen(
    appViewModel: AppViewModel,
    viewModel: LoginViewModel,
    navigateToMain: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCurrentUser()
    }
    LaunchedEffect(uiState) {
        if (uiState is LoginUiState.Finished) {
            navigateToMain()
        }
        val topBarVisible = uiState is LoginUiState.Default &&
                !(uiState as LoginUiState.Default).userHasEmptyFields()
        appViewModel.updateLoginTopBarVisibility(topBarVisible)
    }

    LoginScreen(
        uiState,
        updateFirstName = viewModel::updateUserFirstName,
        updateLastName = viewModel::updateUserLastName,
        updatePhone = viewModel::updateUserPhone,
        login = viewModel::saveUser,
    )
}

@Composable
private fun LoginScreen(
    uiState: LoginUiState,
    updateFirstName: (String) -> Unit,
    updateLastName: (String) -> Unit,
    updatePhone: (String) -> Unit,
    login: () -> Unit,
) {
    when(uiState) {
        is LoginUiState.Default -> {
            if (uiState.loading) {
                LoadingContent()
            } else {
                LoginContent(
                    firstName = uiState.user.firstName,
                    lastName = uiState.user.lastName,
                    phone = uiState.user.phone,
                    loginEnabled = !uiState.userHasEmptyFields(),
                    updateFirstName = updateFirstName,
                    updateLastName = updateLastName,
                    updatePhone = updatePhone,
                    login = login,
                )
            }
        }
        is LoginUiState.Finished -> {}
    }
}

@Composable
private fun LoadingContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun LoginContent(
    firstName: String,
    lastName: String,
    phone: String,
    loginEnabled: Boolean,
    updateFirstName: (String) -> Unit,
    updateLastName: (String) -> Unit,
    updatePhone: (String) -> Unit,
    login: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Paddings.MEDIUM.size),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EMInputField(
            modifier = Modifier.fillMaxWidth(),
            value = firstName,
            onValueChange = updateFirstName,
            placeholder = stringResource(id = R.string.first_name)
        )
        Spacer(modifier = Modifier.height(Paddings.MEDIUM.size))
        EMInputField(
            modifier = Modifier.fillMaxWidth(),
            value = lastName,
            onValueChange = updateLastName,
            placeholder = stringResource(id = R.string.last_name)
        )
        Spacer(modifier = Modifier.height(Paddings.MEDIUM.size))
        EMPhoneInputField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = updatePhone,
            placeholder = stringResource(id = R.string.phone_number)
        )
        Spacer(modifier = Modifier.height(Paddings.MEDIUM.size))
        EMButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login_action),
            enabled = loginEnabled,
            onClick = login,
        )
    }
}

@Preview
@Composable
private fun LoginPreview() {
    EffectiveMobileTesterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                uiState = LoginUiState.Default(),
                updateFirstName = {},
                updateLastName = {},
                updatePhone = {},
                login = {},
            )
        }
    }
}