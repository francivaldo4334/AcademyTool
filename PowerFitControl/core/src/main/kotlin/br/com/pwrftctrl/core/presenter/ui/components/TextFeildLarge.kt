package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
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
    ){
      Text(
        text = label,
        fontSize = 12.sp,
        color = extendedColors.primary500,
        modifier = Modifier.fillMaxWidth()
      )
      BaseTextField(
          value = value,
          enabled = enabled,
          onValueChange = onValueChange,
          errorMessage = errorMessage,
          decorationBox = { fieldBox ->
              Box(
                  modifier =
                  modifier                      .heightIn(min = 72.dp)
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
){
    form.getField(key)?.let{ field -> 
        TextFieldLarge(
            label = label,
            value = field.value,
            enabled = !form.isOnlyRead.value,
            onValueChange = {
                form.validateField(key, it)
                field.value = it
            },
            modifier = modifier,
            errorMessage = form.getErrorMessage(key)?.value?: ""
        )
    }
}

