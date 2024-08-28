package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

@Composable
fun SearchField() {
        val (value, onValueChange) = remember { mutableStateOf("") }
        val extendedColors = LocalExtendedColors.current
        BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                decorationBox = { fieldBox ->
                        Row(
                                modifier =
                                        Modifier.border(
                                                        width = 2.dp,
                                                        color = extendedColors.secondary100,
                                                        shape = RoundedCornerShape(8.dp)
                                                )
                                                .height(40.dp)
                                                .widthIn(min = 272.dp, max = 400.dp)
                                                .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                                Icon(
                                        painter = R.vectors.ic_search,
                                        contentDescription = "Icone de Pesquisa",
                                        tint = extendedColors.secondary600
                                )
                                if (value.isEmpty()) {
                                        Text(R.strings.search, color = extendedColors.secondary500)
                                } else {
                                        fieldBox() 
                                }
                        }
                }
        )
}
