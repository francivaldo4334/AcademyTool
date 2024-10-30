package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.utils.Form


@Composable
fun TextFieldLarge(
    label: String,
    value: String,
    errorMessage: String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    val extendedColors = LocalExtendedColors.current
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = extendedColors.primary500,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
        BaseTextField(
            value = value,
            enabled = enabled,
            onValueChange = onValueChange,
            errorMessage = errorMessage,
            modifier = modifier.background(if (enabled)  Color.Transparent else  extendedColors.secondary50,  RoundedCornerShape(8.dp)),
            decorationBox = { fieldBox ->
                Box(
                    modifier =
                    modifier
                        .heightIn(min = 72.dp)
                        .widthIn(min = 150.dp)
                        .padding(12.dp),
                    contentAlignment = Alignment.TopStart
                ) {
                    fieldBox()
                }
            }
        )
    }
}

@Composable
fun TextFieldLarge(
    label: String,
    form: Form,
    key: String,
    modifier: Modifier = Modifier,
) {
    form.getField(key)?.let { field ->
        TextFieldLarge(
            label = label,
            value = field.value,
            enabled = !form.isOnlyRead.value,
            onValueChange = {
                form.validateField(key, it)
                field.value = it
            },
            modifier = modifier,
            errorMessage = form.getErrorMessage(key)?.value ?: ""
        )
    }
}

