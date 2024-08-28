package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextButton as materialTextButton
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun TextButton(onClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    val extendedColors = LocalExtendedColors.current
    materialTextButton(
      onClick = onClick,
      content = content,
      shape = RoundedCornerShape(8.dp),
      colors = ButtonDefaults.textButtonColors(
          backgroundColor = extendedColors.primary500,
          contentColor = extendedColors.primary50,
      ),
      modifier = Modifier.height(40.dp)
    )
}
