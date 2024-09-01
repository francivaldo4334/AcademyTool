package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.Table
import br.com.pwrftctrl.core.presenter.ui.components.HeaderItem
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
      ),
    )
  )
}
