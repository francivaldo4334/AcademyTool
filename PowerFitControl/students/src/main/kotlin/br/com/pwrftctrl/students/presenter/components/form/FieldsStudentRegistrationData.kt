package br.com.pwrftctrl.students.presenter.components.form

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import br.com.pwrftctrl.core.presenter.ui.components.TextFieldLarge
import br.com.pwrftctrl.students.presenter.forms.FormStudentRegistrationData

@Composable
fun ColumnScope.FieldsStudentRegistrationData(formStudentRegistrationData: FormStudentRegistrationData) {
  Row(
    modifier = Modifier.fillMaxWidth()
  ){
    TextField(
      label = "Inicio",
      form = formStudentRegistrationData,
      key = FormStudentRegistrationData.Field.START_DATE.name,
      modifier = Modifier.fillMaxWidth(0.5f).padding(end=6.dp) 
    ) 
    TextField(
      label = "Vencimento",
      form = formStudentRegistrationData,
      key = FormStudentRegistrationData.Field.END_DATE.name,
      modifier = Modifier.fillMaxWidth().padding(start=6.dp) 
    ) 
  }
  TextField(
    label = "Modalidade",
    form = formStudentRegistrationData,
    key = FormStudentRegistrationData.Field.MODALITY.name,
    modifier = Modifier.fillMaxWidth()
  )
  TextFieldLarge(
    label = "Observação",
    form = formStudentRegistrationData,
    key = FormStudentRegistrationData.Field.OBSERVATION.name,
    modifier = Modifier.fillMaxWidth()
  )
}
