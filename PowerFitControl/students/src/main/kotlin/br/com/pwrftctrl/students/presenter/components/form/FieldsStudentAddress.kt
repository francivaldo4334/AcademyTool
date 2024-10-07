package br.com.pwrftctrl.students.presenter.components.form

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.forms.FormStudentAddress

fun LazyListScope.FieldsStudentAddress(formStudentAddress: FormStudentAddress) {
  item {
    Column(
      verticalArrangement = Arrangement.spacedBy(16.dp),
      modifier = Modifier.padding(16.dp)
    ) {
      TextField(
        label = R.strings.city,
        form = formStudentAddress,
        key = FormStudentAddress.Field.CITY.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.neighborhood,
        form = formStudentAddress,
        key = FormStudentAddress.Field.NEIGHBORHOOD.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.street,
        form = formStudentAddress,
        key = FormStudentAddress.Field.STREET.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.evenue,
        form = formStudentAddress,
        key = FormStudentAddress.Field.AVENUE.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.zip_code,
        form = formStudentAddress,
        key = FormStudentAddress.Field.ZIP_CODE.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.house_number,
        form = formStudentAddress,
        key = FormStudentAddress.Field.NUMBER.name,
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        label = R.strings.reference,
        form = formStudentAddress,
        key = FormStudentAddress.Field.REFERENCE.name,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

