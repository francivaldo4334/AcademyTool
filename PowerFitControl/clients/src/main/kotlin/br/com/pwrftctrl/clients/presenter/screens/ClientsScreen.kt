package br.com.pwrftctrl.clients.presenter.screens

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.clients.presenter.header.ClientsHeader
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen

@Composable
@Preview
fun ClientsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier =
            Modifier.fillMaxHeight()
                .widthIn(max = LocalDimensionsSizeScreen.maxWidth)
                .padding(horizontal = 16.dp)
        ) { ClientsHeader() }
    }
}
