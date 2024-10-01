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
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.forms.FormStudentData
import br.com.pwrftctrl.core.presenter.ui.components.TextField
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.ui.theme.extendedColorScheme
import br.com.pwrftctrl.core.presenter.ui.components.CompanyLogo
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import br.com.pwrftctrl.core.presenter.ui.components.TextField

fun LazyListScope.FieldsStudentData(formStudent: FormStudentData) {
    item {
        var avatarSize by remember {
            mutableStateOf(0.dp)
        }
        var columnHeight by remember {
            mutableStateOf(0.dp)
        }
        val extendedColor = LocalExtendedColors.current
        LaunchedEffect(columnHeight) {
            if (avatarSize == 0.dp) {
                avatarSize = columnHeight
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth()
                        .drawBehind {
                            columnHeight = this.size.height.toDp()
                        }
                ) {
                    TextField(
                        label = "Nome",
                        form = formStudent,
                        key = FormStudentData.Field.FIRST_NAME.name,
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        label = "Sobre nome",
                        form = formStudent,
                        key = FormStudentData.Field.LAST_NAME.name,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Box() {
                    CompanyLogo(
                        modifier = Modifier.size(avatarSize)
                    )
                    IconButton(
                        painter = R.vectors.ic_upload,
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
                label = "CPF",
                form = formStudent,
                key = FormStudentData.Field.CPF.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = "Data de nascimento",
                form = formStudent,
                key = FormStudentData.Field.BIRTHDATE.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = "E-mail",
                form = formStudent,
                key = FormStudentData.Field.EMAIL.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = "Telefone 1",
                form = formStudent,
                key = FormStudentData.Field.PHONE_1.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = "Telefone 2",
                form = formStudent,
                key = FormStudentData.Field.PHONE_2.name,
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                label = "Whatsapp",
                form = formStudent,
                key = FormStudentData.Field.WHATSAPP.name,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
