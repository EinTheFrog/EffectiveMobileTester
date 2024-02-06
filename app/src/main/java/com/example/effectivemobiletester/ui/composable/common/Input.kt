package com.example.effectivemobiletester.ui.composable.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletester.R
import com.example.effectivemobiletester.ui.theme.EffectiveMobileTesterTheme

@Composable
fun EMInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,

) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,

            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            CloseIcon(
                onClick = { onValueChange("") },
                visible = value.isNotEmpty()
            )
        }
    )
}

@Composable
private fun CloseIcon(
    visible: Boolean,
    onClick: () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Icon(
            modifier = Modifier.clickable { onClick() },
            painter = painterResource(id = R.drawable.baseline_close_24),
            contentDescription = stringResource(id = R.string.close_icon),
        )
    }
}

@Preview
@Composable
fun EMInputFieldPreview() {
    EffectiveMobileTesterTheme {
        EMInputField(value = "", onValueChange = {}, placeholder = "Phone")
    }
}