package com.example.effectivemobiletester.ui.composable.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletester.R
import com.example.effectivemobiletester.ui.composable.common.EMInputField
import com.example.effectivemobiletester.ui.theme.EffectiveMobileTesterTheme
import com.example.effectivemobiletester.ui.theme.Paddings
import com.example.effectivemobiletester.ui.viewmodel.login.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
) {
    LoginScreen()
}

@Composable
private fun LoginScreen() {
    Scaffold(

    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues),
        ) {
            LoginContent()
        }
    }
}

@Composable
private fun LoginContent() {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = Paddings.MEDIUM.size),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EMInputField(
            value = "",
            onValueChange = {},
            placeholder = stringResource(id = R.string.first_name)
        )
        Spacer(modifier = Modifier.height(Paddings.MEDIUM.size))
        EMInputField(
            value = "",
            onValueChange = {},
            placeholder = stringResource(id = R.string.last_name)
        )
        Spacer(modifier = Modifier.height(Paddings.MEDIUM.size))
        EMInputField(
            value = "",
            onValueChange = {},
            placeholder = stringResource(id = R.string.phone_number)
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
            LoginScreen()
        }
    }
}