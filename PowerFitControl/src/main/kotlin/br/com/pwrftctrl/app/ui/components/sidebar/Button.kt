package br.com.pwrftctrl.app.ui.components.sidebar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Button() {
        Button(
                onClick = {},
                contentPadding = PaddingValues(8.dp),
                colors =
                        ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.background
                        )
        ) { Box(modifier = Modifier.size(24.dp)) }
}
