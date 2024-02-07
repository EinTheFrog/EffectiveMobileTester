package com.example.effectivemobiletester.ui.composable.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Subtitle(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.bodySmall.fontSize,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.secondaryContainer,
    )
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onBackground,
    )
}

@Composable
fun BottomBarLabel(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.labelSmall.fontSize,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.secondaryContainer,
    )
}