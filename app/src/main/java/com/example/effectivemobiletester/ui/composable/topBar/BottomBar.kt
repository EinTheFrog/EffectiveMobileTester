package com.example.effectivemobiletester.ui.composable.topBar

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.effectivemobiletester.R
import com.example.effectivemobiletester.ui.composable.common.BottomBarLabel
import com.example.effectivemobiletester.ui.composable.common.Subtitle
import com.example.effectivemobiletester.ui.navigation.AppDestination
import com.example.effectivemobiletester.ui.navigation.MainDestination
import com.example.effectivemobiletester.ui.viewmodel.app.AppUiState


@Composable
fun EMBottomBar(
    appUiState: AppUiState,
    navigate: (String) -> Unit
) {
    Crossfade(targetState = appUiState, label = "") {
        when(val currentUiState = it) {
            is AppUiState.Login -> LoginBottomBar()
            is AppUiState.Main -> {
                MainBottomBar(currentRoute = currentUiState.destination.route, navigate = navigate)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBottomBar() {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Subtitle(text = stringResource(id = R.string.login_policy_1))
                Subtitle(text = stringResource(id = R.string.login_policy_2))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}

@Composable
private fun MainBottomBar(
    currentRoute: String,
    navigate: (String) -> Unit,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
    ) {
        MainDestination.entries.forEach { item ->
            val selected = currentRoute == item.route
            val iconTine = if (selected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondaryContainer
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navigate(item.route)
                },
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = stringResource(id = item.label),
                    tint = iconTine,
                ) },
                label = { BottomBarLabel(text= stringResource(id = item.label)) }
            )
        }
    }
}