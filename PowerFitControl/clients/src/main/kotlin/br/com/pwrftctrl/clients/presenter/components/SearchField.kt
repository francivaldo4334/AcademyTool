package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SearchField() {
        var (value, onValueChange) = remember { mutableStateOf("") }
        BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
        )
}
