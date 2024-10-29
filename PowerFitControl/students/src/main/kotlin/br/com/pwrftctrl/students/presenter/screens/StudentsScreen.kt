package br.com.pwrftctrl.students.presenter.screens

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import br.com.pwrftctrl.students.presenter.components.ClientsTable
import br.com.pwrftctrl.students.presenter.components.FiltersRow
import br.com.pwrftctrl.core.presenter.ui.components.Pagination
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.components.form.ModalCreateStudent
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserPlus

@Composable
fun ColumnScope.StudentsScreen() {
    var currentPage by remember { mutableStateOf(1) }
    var openModalAddStudent by remember{ mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        FiltersRow()
        IconButton(
                painter = rememberVectorPainter(Lucide.UserPlus),
                contentDescription = "Adicionar novo aluno",
                onClick = {
                    openModalAddStudent = true
                }
        )
    }
    ClientsTable()
    Pagination(
        helpText = R.strings.total_number_of_students,
        countItems = 100,
        perPage = 4,
        selectedPage = currentPage,
        onChange = { currentPage = it }
    )
    if (openModalAddStudent) {
        ModalCreateStudent(
            onDismissRequest = {
                openModalAddStudent = false
            }
        )
    }
}


