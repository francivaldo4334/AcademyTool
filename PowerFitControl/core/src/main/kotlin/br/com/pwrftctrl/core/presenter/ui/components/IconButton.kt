package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun IconButton(painter: Painter, contentDescription: String, onClick: () -> Unit) {
    val extendedColors = LocalExtendedColors.current
    IconButton(
        onClick = onClick,
        modifier =
        Modifier.size(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(extendedColors.primary500)
            .padding(0.dp),
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp),
            tint = extendedColors.primary50
        )
    }
}
