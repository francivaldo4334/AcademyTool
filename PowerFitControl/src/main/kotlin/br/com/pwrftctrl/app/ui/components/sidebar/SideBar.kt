package br.com.pwrftctrl.app.ui.components.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.secondary_900

@Composable
fun SideBar() {
  Box(modifier = Modifier.fillMaxHeight().width(56.dp).background(secondary_900).padding(8.dp)) {
    Column(modifier = Modifier.align(Alignment.Center)) {
      Button()
      Button()
      Button()
    }
  }
}
