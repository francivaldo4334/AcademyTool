package br.com.pwrftctrl.app.ui.components.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.app.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.Resources as R

@Composable
fun SideBar() {
  val extendedColors = LocalExtendedColors.current
  Box(
          modifier =
                  Modifier.fillMaxHeight()
                          .width(56.dp)
                          .background(extendedColors.secondary900)
                          .padding(8.dp),
  ) {
    Column(modifier = Modifier.align(Alignment.Center)) {
      Button(textHelp = R.strings.controle_de_clientes)
      Button(textHelp = R.strings.visualizar_metricas)
      Button(textHelp = R.strings.controle_de_equipamentos)
      Button(textHelp = R.strings.controle_financeiro)
    }
  }
}
