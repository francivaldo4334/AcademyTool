package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton as materialTextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun TextButton(
        enabled: Boolean = true,
        onClick: () -> Unit,
        content: @Composable RowScope.() -> Unit
) {
    val extendedColors = LocalExtendedColors.current
    materialTextButton(
            enabled = enabled,
            onClick = onClick,
            content = content,
            shape = RoundedCornerShape(8.dp),
            colors =
                    ButtonDefaults.textButtonColors(
                        backgroundColor = if (enabled) extendedColors.primary500 else extendedColors.secondary300,
                        contentColor = MaterialTheme.colors.background,
                   ),
            modifier = Modifier.height(40.dp)
    )
}
