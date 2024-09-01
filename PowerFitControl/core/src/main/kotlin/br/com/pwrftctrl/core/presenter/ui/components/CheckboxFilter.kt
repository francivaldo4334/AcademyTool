package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun CheckboxFilter(painter: Painter, checked: Boolean, contentDescription: String, onChange: (Boolean) -> Unit) {
    val extendedColors = LocalExtendedColors.current
    PopoverTip(
        offset = IntOffset(0, 4),
        alignment = Alignment.BottomStart,
        contentComponent = {
            Box(
                modifier = Modifier
                    .clickable { onChange(!checked) }
                    .size(32.dp)
                    .background(if (checked) extendedColors.primary500 else extendedColors.secondary200),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(24.dp),
                    tint = if (checked) extendedColors.primary50 else extendedColors.secondary500
                )
            }
        },
    ) {
        Text(contentDescription, color = extendedColors.secondary900)
    }
}
