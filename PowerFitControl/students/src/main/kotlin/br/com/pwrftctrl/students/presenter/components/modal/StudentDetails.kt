package br.com.pwrftctrl.students.presenter.components.modal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.core.presenter.ui.components.BaseModal
import br.com.pwrftctrl.core.presenter.ui.components.TextButton
import br.com.pwrftctrl.core.presenter.ui.components.RedButton
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import br.com.pwrftctrl.core.presenter.ui.components.TextBottomSelectionItem
import br.com.pwrftctrl.core.presenter.ui.components.FormSelection
import br.com.pwrftctrl.core.presenter.ui.components.FormItemSelection
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.utils.Form
import br.com.pwrftctrl.students.presenter.components.form.FieldsStudentAddress
import br.com.pwrftctrl.students.presenter.components.form.FieldsStudentData
import br.com.pwrftctrl.students.presenter.components.form.FieldsStudentRegistrationData
import br.com.pwrftctrl.students.presenter.forms.*
import javax.swing.Box

@Composable
private fun RowBottomButtons(
    formStudent: Form
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (formStudent.isOnlyRead.value) {
                TextButton(
                    onClick = {
                        formStudent.setIsOnlyRead(false)
                    },
                ) { Text(R.strings.edit) }
            }
            RedButton(
                onClick = {
                    if (!formStudent.isOnlyRead.value) {
                        formStudent.setIsOnlyRead(true)
                    } else {
                        //TODO: excluir
                    }
                },
            ) {
                Text(
                    if (formStudent.isOnlyRead.value) R.strings.exclude
                    else R.strings.cancell
                )
            }
        }
        if (!formStudent.isOnlyRead.value) {
            TextButton(
                onClick = {
                    formStudent.onSubmit()
                },
            ) { Text(R.strings.save) }
        }
    }
}

@Composable
fun StudentDetails(
    onDismissRequest: () -> Unit,
) {
    val formStudentData = FormStudentData()
    val formStudentAddress = FormStudentAddress()
    val formStudentRegistrationData = FormStudentRegistrationData()
    val formStudent = formStudentData + formStudentAddress + formStudentRegistrationData
    LaunchedEffect(Unit) {
        formStudent.setIsOnlyRead(true)
    }
    val STUDENT = 0
    val ADDRESS = 1
    val REGISTER = 2
    var optionSelected by remember {
        mutableStateOf(STUDENT)
    }
    BaseModal(autoDimiss = true, onDismissRequest = onDismissRequest, content = {
        Column(
            modifier = Modifier.height(640.dp)
        ) {
            IconButton(
                containerColor = Color.Transparent,
                contentColor = LocalExtendedColors.current.secondary900,
                modifier = Modifier.size(48.dp).align(Alignment.End),
                painter = R.vectors.ic_x,
                contentDescription = "Botao de fechar",
                onClick = onDismissRequest
            )
            FormSelection(
                options = listOf(
                    FormItemSelection({ Text(R.strings.student) }, {
                        optionSelected = STUDENT
                    }),
                    FormItemSelection({ Text(R.strings.address) }, {
                        optionSelected = ADDRESS
                    }),
                    FormItemSelection({ Text(R.strings.student_register) }, {
                        optionSelected = REGISTER
                    }),
                ),
                modifier = Modifier.padding(horizontal = 12.dp).weight(1f).wrapContentWidth(),
            ) {
                LazyColumn {
                    when (optionSelected) {
                        STUDENT -> FieldsStudentData(formStudentData)
                        ADDRESS -> FieldsStudentAddress(formStudentAddress)
                        REGISTER -> FieldsStudentRegistrationData(formStudentRegistrationData)
                    }
                }
            }
            RowBottomButtons(formStudent)
        }
    })
}
