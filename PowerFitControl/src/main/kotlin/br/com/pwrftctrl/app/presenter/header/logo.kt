package br.com.pwrftctrl.app.presenter.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun Logo() {
    val extendedColors = LocalExtendedColors.current
    Box(
        modifier =
        Modifier.size(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(extendedColors.primary500)
    ) {}
}
