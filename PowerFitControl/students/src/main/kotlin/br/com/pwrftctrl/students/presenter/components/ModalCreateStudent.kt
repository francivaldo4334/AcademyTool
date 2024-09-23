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

@Composable
fun ModalCreateStudent(
        onDismissRequest: () -> Unit
) {
        var indexTask by remember {
                mutableStateOf(1)
        }
        BaseModal(onDismissRequest = onDismissRequest) {
                ProgressIndicatorSide(
                        indexTask = indexTask,
                        title = "Teste 1",
                        onCancell = {
                                onDismissRequest()
                        },
                        onSubmmit = {},
                        modifier = Modifier.heightIn(min = 490.dp),
                        tasks =
                                listOf(
                                        "Dados pessoais",
                                        "Endereço do aluno",
                                        "Informações de matricula",
                                ),
                        onChangeCurrentTaskCompleted = {},
                        onChangeIndexTask = {
                                indexTask = it
                        },
                ) { 
                        TextField(
                                label = "Teste", 
                                value = "") {

                        }
                }
        }
}
