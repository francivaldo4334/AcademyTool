package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun PaginationButton(
    selected: Boolean = false,
    enable: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val extendedColors = LocalExtendedColors.current
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(enable) {
                onClick()
            }
            .size(40.dp)
            .background(
                if (selected) {
                    extendedColors.primary500
                } else if (enable) {
                    extendedColors.secondary200
                } else {
                    extendedColors.secondary50
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
