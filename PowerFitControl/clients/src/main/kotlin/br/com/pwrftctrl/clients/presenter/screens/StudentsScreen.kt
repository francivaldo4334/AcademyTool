package br.com.pwrftctrl.clients.presenter.screens

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.*
import br.com.pwrftctrl.clients.presenter.components.ClientsTable
import br.com.pwrftctrl.clients.presenter.components.FiltersRow
import br.com.pwrftctrl.core.presenter.ui.components.Pagination
import br.com.pwrftctrl.core.utils.R

@Composable
fun ColumnScope.StudentsScreen() {
    var currentPage by remember { mutableStateOf(1) }
    FiltersRow()
    ClientsTable()
    Pagination(
        helpText = R.strings.total_number_of_students,
        countItems = 400,
        perPage = 11,
        selectedPage = currentPage,
        onChange = { currentPage = it }
    )
}


