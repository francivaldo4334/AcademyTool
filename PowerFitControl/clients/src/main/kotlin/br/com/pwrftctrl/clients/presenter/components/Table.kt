package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape 
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun ColumnScope.Table() {
  val extendedColors = LocalExtendedColors.current
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f)
      .border(2.dp, extendedColors.secondary100, RoundedCornerShape(12.dp))
      .background(extendedColors.secondary100)
  ){
    //TODO:
  }
}
