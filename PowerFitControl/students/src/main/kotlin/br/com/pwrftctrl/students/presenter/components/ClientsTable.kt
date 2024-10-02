package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import br.com.pwrftctrl.students.presenter.enums.StudentStateFilter
import br.com.pwrftctrl.students.presenter.components.modal.StudentDetails
import br.com.pwrftctrl.core.presenter.ui.components.Table
import br.com.pwrftctrl.core.presenter.ui.components.HeaderItem
import br.com.pwrftctrl.core.presenter.ui.components.ProfileImage
import br.com.pwrftctrl.core.presenter.ui.components.Clipboard
import br.com.pwrftctrl.core.utils.R

@Composable
fun ColumnScope.ClientsTable() {
  var openDetails by remember {
    mutableStateOf(false)
  }
  Table(
    headerItems = listOf(
      HeaderItem(
        title = R.strings.avatar,
        maxWidth = 72.dp,
        minWidth = 72.dp,
      ),
      HeaderItem(
        title = R.strings.name,
        onSortAction = {}
      ),
      HeaderItem(
        title = R.strings.register,
        minWidth = 120.dp,
        maxWidth = 72.dp,
        onSortAction = {}
      ),
      HeaderItem(
        title = R.strings.age,
        maxWidth = 100.dp,
        minWidth = 72.dp,
        onSortAction = {}
      ),
      HeaderItem(
        title = R.strings.email,
      ),
      HeaderItem(
        title = R.strings.status,
        minWidth = 200.dp,
        onSortAction = {}
      ),
      HeaderItem(
        title = R.strings.phone_or_whatsapp,
        minWidth = 200.dp
      ),
    ) 
  ) {
    val textWithStyle: @Composable (text: String) -> Unit = {
        Text(
          text = it,
          fontSize = 12.sp,
          fontWeight = FontWeight.Medium,
          modifier = Modifier.padding(start = 12.dp)
        )
    }
    row(
      key = 0,
      {
        ProfileImage(
          fileName = "teste.jpeg",
          modifier = Modifier.padding(12.dp).size(32.dp)
        )
      },
      { textWithStyle("Nome completo do usuário") },
      { textWithStyle("10/01/2024") },
      { textWithStyle("24 anos") },
      { textWithStyle("francivaldodev@gmail.com")},
      {
        Row(
          modifier = Modifier.fillMaxSize(),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          StatusCounter(status = StudentStateFilter.NO_PAID, count = 3)
          StatusCounter(status = StudentStateFilter.PAID, count = 3)
          StatusCounter(status = StudentStateFilter.MISSING, count = 3)
        }
      },
      {
        Column(
          verticalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.padding(vertical = 8.dp)
        ) {
          Clipboard("(86) 88 9 0000000")
          Clipboard("(86) 88 9 0000000")
        }
      },
      onClick = {
        openDetails = true
      })
  }
  if (openDetails) {
    StudentDetails(
      onDismissRequest = {
        openDetails = false
      }
    )
  }
}
