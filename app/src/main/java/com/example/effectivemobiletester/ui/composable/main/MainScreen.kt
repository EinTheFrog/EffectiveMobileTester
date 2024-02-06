package com.example.effectivemobiletester.ui.composable.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.effectivemobiletester.ui.viewmodel.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
) {
    Scaffold() { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues),
        ) {
            Text(text = "Main screen")
        }
    }
}

