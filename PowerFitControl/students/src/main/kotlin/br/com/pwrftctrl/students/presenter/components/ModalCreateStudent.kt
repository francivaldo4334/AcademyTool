package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.layout.Row
import  androidx.compose.runtime.Composable
import br.com.pwrftctrl.core.presenter.ui.components.BaseModal
import br.com.pwrftctrl.core.presenter.ui.components.ProgressIndicatorSide

@Composable
fun ModalCreateStudent(

) {
    BaseModal(
        onDismissRequest = {

        }
    ) {
        Row {
            ProgressIndicatorSide(
                tasks = listOf(
                    "Tarefa 1",
                    "Tarefa 2",
                    "Tarefa 3",
                    "Tarefa 4",
                    "Tarefa 5",
                )
            )
        }
    }
}
