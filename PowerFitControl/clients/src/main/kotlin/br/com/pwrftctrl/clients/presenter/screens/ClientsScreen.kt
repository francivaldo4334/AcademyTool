package br.com.pwrftctrl.clients.presenter.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.clients.presenter.components.Header
import br.com.pwrftctrl.clients.presenter.enums.OptionsType
import br.com.pwrftctrl.clients.presenter.viewmodels.ClientsViewModel
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen
import br.com.pwrftctrl.core.presenter.viewmodels.viewModel

@Composable
fun ClientsScreen() {
    val clientsManagerViewModel = viewModel<ClientsViewModel>()
    val selectedOption by clientsManagerViewModel.selectedOption.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier =
            Modifier.fillMaxHeight()
                .widthIn(max = LocalDimensionsSizeScreen.maxWidth)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header()
            when (selectedOption) {
                OptionsType.STUDENTS ->
                    StudentsScreen()

                else -> {

                }
            }
        }
    }
}
