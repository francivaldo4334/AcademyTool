package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun IconButton(
        cornerRadius: Dp = 8.dp,
        containerColor: Color = LocalExtendedColors.current.primary500,
        contentColor: Color = LocalExtendedColors.current.primary50,
        modifier: Modifier = Modifier,
        painter: Painter,
        contentDescription: String,
        onClick: () -> Unit
) {
    IconButton(
            onClick = onClick,
            modifier =
                    modifier.size(40.dp)
                            .background(containerColor, shape = RoundedCornerShape(cornerRadius))
                            .padding(4.dp),
    ) {
        Icon(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.size(24.dp),
                tint = contentColor
        )
    }
}
