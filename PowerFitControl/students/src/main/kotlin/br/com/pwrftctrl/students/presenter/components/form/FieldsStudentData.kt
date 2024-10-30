package br.com.pwrftctrl.students.presenter.components.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.forms.FormStudentData
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.ui.theme.extendedColorScheme
import br.com.pwrftctrl.core.presenter.ui.components.CompanyLogo
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Upload

fun LazyListScope.FieldsStudentData(formStudent: FormStudentData) {
    item {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth()
                ) {
                    TextField(
                        label = R.strings.name,
                        form = formStudent,
                        key = FormStudentData.Field.FIRST_NAME.name,
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        label = R.strings.last_name,
                        form = formStudent,
                        key = FormStudentData.Field.LAST_NAME.name,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Box() {
                    CompanyLogo(
                        modifier = Modifier.size(130.dp)
                    )
                    IconButton(
                        painter = rememberVectorPainter(Lucide.Upload),
                        contentDescription = "Botão de upload",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.TopEnd)
                            .graphicsLayer {
                                val elevation = 4.dp.toPx()
                                translationX += elevation
                                translationY -= elevation
                            }
                    ) {

                    }
                }
            }
            TextField(
                label = R.strings.cpf,
                form = formStudent,
                key = FormStudentData.Field.CPF.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = R.strings.date_of_birth,
                form = formStudent,
                key = FormStudentData.Field.BIRTHDATE.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = R.strings.email,
                form = formStudent,
                key = FormStudentData.Field.EMAIL.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = R.strings.phone_1,
                form = formStudent,
                key = FormStudentData.Field.PHONE_1.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = R.strings.phone_2,
                form = formStudent,
                key = FormStudentData.Field.PHONE_2.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = R.strings.whatsapp,
                form = formStudent,
                key = FormStudentData.Field.WHATSAPP.name,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
