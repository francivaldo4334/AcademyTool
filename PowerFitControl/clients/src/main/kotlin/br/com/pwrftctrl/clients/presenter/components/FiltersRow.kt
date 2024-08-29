package br.com.pwrftctrl.clients.presenter.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.components.SearchField
import br.com.pwrftctrl.core.presenter.ui.components.TextButton
import br.com.pwrftctrl.core.presenter.ui.components.SelectField
import br.com.pwrftctrl.core.utils.R

@Composable
fun FiltersRow() {
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
        }
    }
}
