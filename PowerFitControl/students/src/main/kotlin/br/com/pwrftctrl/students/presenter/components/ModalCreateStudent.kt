package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import  androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
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
                modifier = Modifier
                    .heightIn(min=490.dp),
                tasks = listOf(
                    "Dados pessoais",
                    "Endereço do aluno",
                    "Informações de matricula",
                )
            ) {

            }
        }
    }
}
