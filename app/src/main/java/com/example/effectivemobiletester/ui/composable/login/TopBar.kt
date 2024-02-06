package com.example.effectivemobiletester.ui.composable.login

import androidx.compose.animation.AnimatedVisibility
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