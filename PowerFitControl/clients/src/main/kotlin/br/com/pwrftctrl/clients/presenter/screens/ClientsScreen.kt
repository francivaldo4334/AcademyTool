package br.com.pwrftctrl.clients.presenter.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.clients.presenter.components.Table
import br.com.pwrftctrl.clients.presenter.components.Header
import br.com.pwrftctrl.clients.presenter.components.FiltersRow
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen
import br.com.pwrftctrl.core.presenter.ui.components.Pagination

@Composable
fun ClientsScreen() {
    var currentPage by remember {
        mutableStateOf(1)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier =
            Modifier.fillMaxHeight()
                .widthIn(max = LocalDimensionsSizeScreen.maxWidth)
                .padding(horizontal = 16.dp)
        ) { 
            Header()
            FiltersRow()
            Table()
            Pagination(
                helpText = "Total de alunos",
                countItems = 400,
                perPage = 11,
                selectedPage = currentPage,
                onChange = {
                    currentPage = it
                }
            )
        }
    }
}
