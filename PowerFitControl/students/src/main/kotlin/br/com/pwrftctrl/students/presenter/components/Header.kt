package br.com.pwrftctrl.students.presenter.components

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
import br.com.pwrftctrl.core.presenter.ui.components.TextBottomSelectionItem
import br.com.pwrftctrl.core.presenter.viewmodels.MyViewModelFactory
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.enums.OptionsType
import br.com.pwrftctrl.students.presenter.viewmodels.ClientsViewModel

@Composable
fun Header() {
    val clientsManagerViewModel = MyViewModelFactory.create(ClientsViewModel::class.java)
    val selectedOption = clientsManagerViewModel.selectedOption.collectAsState()
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(R.strings.clients, fontSize = 25.sp, fontWeight = FontWeight.Normal)
        Row() {
            TextBottomSelectionItem(
                    R.strings.clients_option_students,
                    selected = OptionsType.STUDENTS == selectedOption.value,
            ) { clientsManagerViewModel.selectOption(OptionsType.STUDENTS) }
            TextBottomSelectionItem(
                    R.strings.clients_option_classes,
                    selected = OptionsType.CLASSES == selectedOption.value,
            ) { clientsManagerViewModel.selectOption(OptionsType.CLASSES) }
            TextBottomSelectionItem(
                    R.strings.clients_option_birthdays,
                    selected = OptionsType.BIRTHDAYS == selectedOption.value,
            ) { clientsManagerViewModel.selectOption(OptionsType.BIRTHDAYS) }
        }
    }
}
