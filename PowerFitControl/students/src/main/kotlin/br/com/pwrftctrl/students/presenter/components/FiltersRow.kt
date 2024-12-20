package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.components.*
import br.com.pwrftctrl.core.utils.R
import com.composables.icons.lucide.BookmarkCheck
import com.composables.icons.lucide.BookmarkX
import com.composables.icons.lucide.Cake
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserX

@Composable
fun RowScope.FiltersRow() {
    var isStateNoPaid by remember { mutableStateOf(false) }
    var isStatePaid by remember { mutableStateOf(false) }
    var isStateBirthday by remember { mutableStateOf(false) }
    var isStateMissing by remember { mutableStateOf(false) }
    Row(
            modifier = Modifier.weight(1f).padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SearchField()
            TextButton(
                    onClick = {
                        // TODO: Click pesquisar
                    }
            ) { Text(text = R.strings.search, fontSize = 10.sp, fontWeight = FontWeight.W300) }
        }
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SelectField(
                    label = R.strings.items_per_page,
                    items = listOf("5", "10", "15"),
                    selectedItem = "5"
            )
            CheckboxexFilterRow {
                CheckboxFilter(
                        checked = isStateNoPaid,
                        painter = rememberVectorPainter(Lucide.BookmarkX),
                        contentDescription = R.strings.students_in_debt,
                        onChange = { isStateNoPaid = !isStateNoPaid }
                )
                CheckboxFilter(
                        checked = isStatePaid,
                        painter = rememberVectorPainter(Lucide.BookmarkCheck),
                        contentDescription = R.strings.students_checkeds,
                        onChange = { isStatePaid = !isStatePaid }
                )
                CheckboxFilter(
                        checked = isStateBirthday,
                        painter = rememberVectorPainter(Lucide.Cake),
                        contentDescription = R.strings.birthdays_of_month,
                        onChange = { isStateBirthday = !isStateBirthday }
                )
                CheckboxFilter(
                        checked = isStateMissing,
                        painter = rememberVectorPainter(Lucide.UserX),
                        contentDescription = R.strings.missing_students,
                        onChange = { isStateMissing = !isStateMissing }
                )
            }
        }
    }
}
