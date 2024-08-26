package br.com.pwrftctrl.core.presenter.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.app.presenter.clients.header.enums.OptionsType
import br.com.pwrftctrl.app.presenter.clients.header.viewmodels.ClientsManagerViewModel
import br.com.pwrftctrl.app.presenter.viewmodels.MyViewModelFactory
import br.com.pwrftctrl.core.utils.Resources as R

@Composable
fun ClientsHeader() {
  Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
    val clientsManagerViewModel = MyViewModelFactory.create(ClientsManagerViewModel::class.java)
    val selectedOption = clientsManagerViewModel.selectedOption.collectAsState()
    Text("Clientes", fontSize = 25.sp, fontWeight = FontWeight.Normal)
    Row() {
      TextButtomSelectionItem(
              R.strings.clients_option_students,
              selected = OptionsType.STUDENTS == selectedOption.value,
      ) { clientsManagerViewModel.selectOption(OptionsType.STUDENTS) }
      TextButtomSelectionItem(
              R.strings.clients_option_classes,
              selected = OptionsType.CLASSES == selectedOption.value,
      ) { clientsManagerViewModel.selectOption(OptionsType.CLASSES) }
      TextButtomSelectionItem(
              R.strings.clients_option_birthdays,
              selected = OptionsType.BIRTHDAYS == selectedOption.value,
      ) { clientsManagerViewModel.selectOption(OptionsType.BIRTHDAYS) }
    }
  }
}
