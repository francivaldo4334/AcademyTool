package br.com.pwrftctrl.app.presenter.clients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.app.presenter.clients.header.ClientsHeader
import br.com.pwrftctrl.app.presenter.ui.dimensions.LocalDimensionsSizeScreen

@Composable
fun ClientsScreen() {
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Column(
            modifier =
                    Modifier.fillMaxHeight()
                            .widthIn(max = LocalDimensionsSizeScreen.maxWidth)
                            .padding(16.dp)
    ) { ClientsHeader() }
  }
}
