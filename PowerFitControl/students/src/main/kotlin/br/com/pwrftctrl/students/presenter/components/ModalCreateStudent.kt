package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.BaseModal
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import br.com.pwrftctrl.core.presenter.ui.components.ProgressIndicatorSide
import br.com.pwrftctrl.students.presenter.forms.FormStudent

@Composable
fun ModalCreateStudent(
        onDismissRequest: () -> Unit
) {
        val formStudent = FormStudent()
        var indexTask by remember {
                mutableStateOf(1)
        }
        BaseModal(onDismissRequest = onDismissRequest) {
                ProgressIndicatorSide(
                        onSubmit = formStudent::onSubmit,
                        indexTask = indexTask,
                        title = "Teste 1",
                        tasks = listOf(
                                "Dados pessoais",
                                "Endereço do aluno",
                                "Informações de matricula",
                        ),
                        onCancell = {
                                onDismissRequest()
                        },
                        modifier = Modifier.heightIn(min = 490.dp),
                        onChangeCurrentTaskCompleted = {},
                        onChangeIndexTask = { indexTask = it },
                ) { 
                        TextField(
                                label = "Nome",
                                form = formStudent,
                                key = formStudent.FIRST_NAME,
                        )
                        TextField(
                                label = "Sobre nome",
                                form = formStudent,
                                key = formStudent.LAST_NAME,
                        )
                }
        }
}
