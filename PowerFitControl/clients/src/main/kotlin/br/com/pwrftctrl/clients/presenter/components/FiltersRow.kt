package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.components.SearchField
import br.com.pwrftctrl.core.presenter.ui.components.TextButton
import br.com.pwrftctrl.core.presenter.ui.components.SelectField
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import br.com.pwrftctrl.core.presenter.ui.components.CheckboxexFilterRow
import br.com.pwrftctrl.core.presenter.ui.components.CheckboxFilter
import br.com.pwrftctrl.clients.presenter.enums.StudentStateFilter
import br.com.pwrftctrl.core.utils.R

@Composable
fun FiltersRow() {
    var isStateNoPaid by remember {
        mutableStateOf(false)
    }
    var isStatePaid by remember {
        mutableStateOf(false)
    }
    var isStateBirthday by remember {
        mutableStateOf(false)
    }
    var isStateMissing by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) { 
            SearchField() 
            TextButton(
                onClick = {
                    //TODO: Click pesquisar
                }
            ){
                Text(
                    text = R.strings.search,
                    fontSize = 12.sp
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) { 
            SelectField(
                label = "Items por página",
                items = listOf("5", "10", "15"),
                selectedItem = "5"
            )
            CheckboxexFilterRow{
                CheckboxFilter(
                    checked = isStateNoPaid,
                    painter = R.vectors.ic_no_money,
                    contentDescription = R.strings.students_in_debt,
                    onChange = { isStateNoPaid = !isStateNoPaid}
                )
                CheckboxFilter(
                    checked = isStatePaid,
                    painter = R.vectors.ic_money,
                    contentDescription = R.strings.students_checkeds,
                    onChange = { isStatePaid = !isStatePaid}
                )
                CheckboxFilter(
                    checked = isStateBirthday,
                    painter = R.vectors.ic_cake,
                    contentDescription = R.strings.birthdays_of_month,
                    onChange = {isStateBirthday = !isStateBirthday}
                )
                CheckboxFilter(
                    checked = isStateMissing,
                    painter = R.vectors.ic_question,
                    contentDescription = R.strings.missing_students,
                    onChange = { isStateMissing = !isStateMissing}
                )
            }
            IconButton(
                painter = R.vectors.ic_profile_add,
                contentDescription = "Adicionar novo aluno",
                onClick = {

                }
            )
        }
    }
}
