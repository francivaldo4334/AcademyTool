package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import br.com.pwrftctrl.core.utils.R

@Composable
fun CancellButton(
        onClick: () -> Unit,
) {
        RedButton(
                onClick = onClick,
        ) { Text(R.strings.cancell) }
}
