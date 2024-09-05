package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import br.com.pwrftctrl.core.presenter.ui.components.Table
import br.com.pwrftctrl.core.presenter.ui.components.HeaderItem
import br.com.pwrftctrl.core.presenter.ui.components.ProfileImage
import br.com.pwrftctrl.core.utils.R

@Composable
fun ColumnScope.ClientsTable() {
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
      { }, { }) { }
  }
}
