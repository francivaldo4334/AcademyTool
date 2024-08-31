package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip

@Composable
fun CheckboxexFilterRow(content: @Composable RowScope.() -> Unit) {
  Row(
    modifier = Modifier.clip(RoundedCornerShape(6.dp)),
    content = content,
  )  
}