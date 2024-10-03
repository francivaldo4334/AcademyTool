package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.MutableState
import androidx.compose.material.Text
import androidx.compose.material.Divider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.utils.Form

@Composable
fun BaseTextField(
    value: String,
    errorMessage: String = "",
    modifier: Modifier = Modifier,
    onFocusChange: (FocusState) -> Unit = {},
    enabled: Boolean = true,
    onValueChange: (String) -> Unit,
    decorationBox: @Composable (@Composable () -> Unit) -> Unit
) {
    var errorTipHeight by remember {
        mutableStateOf(0)
    }
    val extendedColors = LocalExtendedColors.current
    BasicTextField(
        modifier = modifier.onFocusChanged {
            onFocusChange(it)
        },
        enabled = enabled,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 14.sp,
        ),
        decorationBox = { fieldBox ->
            Column(
                horizontalAlignment = Alignment.End
            ){
                Box(
                    modifier = Modifier.border(
                        width = 2.dp,
                        color = if(errorMessage.isNotEmpty()) extendedColors.red100 else extendedColors.secondary100,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(if (!enabled) extendedColors.secondary100 else Color.Transparent, shape = RoundedCornerShape(8.dp))
                ){
                    decorationBox(fieldBox)
                }
                AnimatedVisibility(errorMessage.isNotEmpty()){
                    Text(
                        text = errorMessage,
                        modifier = Modifier.drawBehind{
                            errorTipHeight = size.height.toInt()
                        },
                        color = extendedColors.red900,
                        fontSize = 10.sp
                    )
                }
            }
        }
    )
}
