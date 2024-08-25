package br.com.pwrftctrl.app.presenter.clients.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ClientsHeader() {
  Column(
          modifier = Modifier.fillMaxWidth(),
  ) {
    Text("Clientes", fontSize = 25.sp, fontWeight = FontWeight.Normal)
    // Menu selectios
  }
}
