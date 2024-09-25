package br.com.pwrftctrl.students.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.*
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.ui.theme.extendedColorScheme
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.forms.FormStudent

@Composable
fun ModalCreateStudent(
        onDismissRequest: () -> Unit
) {
        val formStudent = FormStudent()
        var indexTask by remember {
                mutableStateOf(1)
        }
        var avatarSize by remember {
                mutableStateOf(0.dp)
        }
        val extendedColor = LocalExtendedColors.current
        BaseModal(onDismissRequest = onDismissRequest) {
                ProgressIndicatorSide(
                        onSubmit = formStudent::onSubmit,
                        indexTask = indexTask,
                        title = "Teste 1",
                        tasks = listOf(
                                "Dados pessoais",
                                "Endereço do aluno",
                                "Informações de matricula",
                        ),
                        onCancell = {
                                onDismissRequest()
                        },
                        modifier = Modifier.heightIn(min = 490.dp),
                        onChangeCurrentTaskCompleted = {},
                        onChangeIndexTask = { indexTask = it },
                ) { 
                        Column(
                                modifier = Modifier.width(490.dp).padding(16.dp).wrapContentWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                                //name, last_name and avatar
                                Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                        Column(
                                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                                modifier = Modifier
                                                        .weight(1f)
                                                        .wrapContentWidth()
                                                        .drawBehind {
                                                                avatarSize = this.size.height.toDp()
                                                        }
                                        ) {
                                                TextField(
                                                        label = "Nome",
                                                        form = formStudent,
                                                        key = formStudent.FIRST_NAME,
                                                        modifier =  Modifier.fillMaxWidth()
                                                )
                                                TextField(
                                                        label = "Sobre nome",
                                                        form = formStudent,
                                                        key = formStudent.LAST_NAME,
                                                        modifier =  Modifier.fillMaxWidth()
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
                                                                        val elevation =  4.dp.toPx()
                                                                        translationX += elevation
                                                                        translationY -= elevation
                                                                }
                                                ){

                                                }
                                        }
                                }
                                TextField(
                                        label = "CPF",
                                        form = formStudent,
                                        key = formStudent.CPF,
                                        modifier = Modifier.fillMaxWidth()
                                )
                                TextField(
                                        label = "Data de nascimento",
                                        form = formStudent,
                                        key = formStudent.BIRTHDATE,
                                        modifier = Modifier.fillMaxWidth()
                                )
                                TextField(
                                        label = "E-mail",
                                        form = formStudent,
                                        key = formStudent.EMAIL,
                                        modifier = Modifier.fillMaxWidth()
                                )
                                TextField(
                                        label = "Telefone",
                                        form = formStudent,
                                        key = formStudent.PHONE_1,
                                        modifier = Modifier.fillMaxWidth()
                                )
                                TextField(
                                        label = "Whatsapp",
                                        form = formStudent,
                                        key = formStudent.WHATSAPP,
                                        modifier = Modifier.fillMaxWidth()
                                )
                        }
                }
        }
}
