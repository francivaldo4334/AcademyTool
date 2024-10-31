package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun RedButton(
        onClick: () -> Unit,
        content: @Composable () -> Unit,
) {
        val extendedColors = LocalExtendedColors.current
        Button(
                onClick = onClick,
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 8.dp),
                shape = RoundedCornerShape(8.dp),
                modifier =
                        Modifier.background(extendedColors.red100, shape = RoundedCornerShape(8.dp))
                                .border(
                                        width = 2.dp,
                                        color = extendedColors.red900,
                                        shape = RoundedCornerShape(8.dp)
                                )
                                .height(40.dp),
                colors =
                        ButtonDefaults.buttonColors(
                                backgroundColor = extendedColors.red100,
                                contentColor = extendedColors.red900
                        ),
                elevation = null,
        ) { content() }
}
