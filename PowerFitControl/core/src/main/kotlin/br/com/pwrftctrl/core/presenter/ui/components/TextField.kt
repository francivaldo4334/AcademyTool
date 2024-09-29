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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.utils.Form

@Composable
private fun animateAlignmentAsState(targetAlignment: Alignment, durationMillis: Int = 300): State<Alignment> {
    val yOffset by animateFloatAsState(
        targetValue = if (targetAlignment == Alignment.CenterStart) 0.5f else 0.9f,
        animationSpec = tween(durationMillis)
    )
    return remember { derivedStateOf { Alignment{size, spacer,_ -> IntOffset(0, ((spacer.height / 2) - (size.height * yOffset)).toInt())} }}
}

@Composable
fun TextField(
    label: String,
    value: String,
    errorMessage: String? = null,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    var errorTipHeight by remember {
        mutableStateOf(0)
    }
    val extendedColors = LocalExtendedColors.current
    var isFocused by remember { mutableStateOf(false)}
    val scaleLabel by animateFloatAsState(
        targetValue = if (isFocused || value.isNotEmpty()) 0.8f else 1f,
        animationSpec = tween(300)
    )
    val labelAlingment by animateAlignmentAsState(
        targetAlignment = if (isFocused || value.isNotEmpty()) Alignment.TopStart else Alignment.CenterStart
    )
    BasicTextField(
        modifier = Modifier.onFocusChanged {
            isFocused = it.isFocused
        },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 14.sp,
        ),
        decorationBox = { fieldBox ->
            Box(
                modifier =
                modifier.border(
                    width = 2.dp,
                    color = extendedColors.secondary100,
                    shape = RoundedCornerShape(8.dp)
                )
                    .heightIn(min = 40.dp)
                    .widthIn(min = 150.dp)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
            ) {
                Box(
                    modifier = Modifier.align(labelAlingment)
                        .graphicsLayer{
                            scaleX = scaleLabel
                            scaleY = scaleLabel 
                            transformOrigin = TransformOrigin(0f,0f)
                        },
                    contentAlignment = Alignment.TopStart
                ){
                    Text(
                        text = label,
                        fontSize = 14.sp,
                        color = extendedColors.primary500,
                        maxLines = 1
                    )
                }
                Box(
                    modifier = Modifier.align(Alignment{size, spacer, _ -> IntOffset(0, (spacer.height * 0.3f).toInt())})
                ) {
                    fieldBox()
                }
            }
            Popup(
                alignment = Alignment.BottomStart,
                offset = IntOffset(4,errorTipHeight),
            ) {
                if (errorMessage != null){
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

@Composable
fun TextField(
    label: String,
    form: Form,
    key: String,
    modifier: Modifier = Modifier,
) {
    form.getField(key)?.let{ field -> 
        TextField(
            label = label,
            value = field.value,
            onValueChange = {
                if (form.validateField(key, it) == null) {
                    field.value = it
                }
            },
            modifier = modifier,
            errorMessage = form.getErrorMessage(key)
        )
    }
}
