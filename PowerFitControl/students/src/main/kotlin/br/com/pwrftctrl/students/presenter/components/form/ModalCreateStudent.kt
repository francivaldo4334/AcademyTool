package br.com.pwrftctrl.students.presenter.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.core.presenter.ui.components.ProgressIndicatorSide
import br.com.pwrftctrl.core.presenter.utils.Form
import br.com.pwrftctrl.students.presenter.forms.*
import br.com.pwrftctrl.core.presenter.ui.components.BaseModal

@Composable
fun ModalCreateStudent(
        onDismissRequest: () -> Unit
) {
        val formStudentData = FormStudentData()
        val formStudentAddress = FormStudentAddress()
        val formStudentRegistrationData = FormStudentRegistrationData()
        val formStudent = formStudentData + formStudentAddress + formStudentRegistrationData
        BaseModal(onDismissRequest = onDismissRequest) {
                ProgressIndicatorSide(
                        title = R.strings.student_registration,
                        form = formStudent,
                        onCancell = {
                                onDismissRequest()
                        },
                        modifier = Modifier.heightIn(min = 490.dp),
                ) { formName ->
                        LazyColumn(
                                modifier = Modifier.width(490.dp).wrapContentWidth(),
                                // verticalArrangement = Arrangement.spacedBy(12.dp)
                        ){ 
                                when(formName) {
                                        formStudentData.toString() -> FieldsStudentData(formStudentData)
                                        formStudentAddress.toString() -> FieldsStudentAddress(formStudentAddress)
                                        formStudentRegistrationData.toString() -> FieldsStudentRegistrationData(formStudentRegistrationData)
                                }
                        }
                }
        }
}
