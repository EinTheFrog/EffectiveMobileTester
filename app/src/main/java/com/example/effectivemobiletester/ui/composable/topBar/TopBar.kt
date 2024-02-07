package com.example.effectivemobiletester.ui.composable.topBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.effectivemobiletester.R
import com.example.effectivemobiletester.ui.composable.common.Title
import com.example.effectivemobiletester.ui.viewmodel.app.AppUiState

@Composable
fun EMTopBar(
    appUiState: AppUiState
) {
    Crossfade(targetState = appUiState, label = "") {
        when(val currentUiState = it) {
            is AppUiState.Login -> LoginTopBar(visible = currentUiState.topBarVisible)
            is AppUiState.Main -> MainTopBar()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopBar(
    visible: Boolean,
) {
    TopAppBar(
        title = {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                Title(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.login_title),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    TopAppBar(
        title = {
            Title(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.catalog),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}