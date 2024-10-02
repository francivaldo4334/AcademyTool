package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import br.com.pwrftctrl.core.utils.R

@Composable
fun CancellButton(
        onClick: () -> Unit,
) {
        RedButton(
                onClick = onClick,
        ) { Text(R.strings.cancell) }
}
