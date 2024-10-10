package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    errorMessage: String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    val extendedColors = LocalExtendedColors.current
    var isFocused by remember { mutableStateOf(false)}
    val scaleLabel by animateFloatAsState(
        targetValue = if (isFocused || value.isNotEmpty()) 0.8f else 1f,
        animationSpec = tween(300)
    )
    val labelAlignment by animateAlignmentAsState(
        targetAlignment = if (isFocused || value.isNotEmpty()) Alignment.TopStart else Alignment.CenterStart
    )
    BaseTextField(
        onFocusChange = {
            isFocused = it.isFocused
        },
        enabled = enabled,
        value = value,
        onValueChange = onValueChange,
        errorMessage = errorMessage,
        modifier =  modifier.wrapContentWidth(),
        decorationBox = { fieldBox ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .widthIn(min = 150.dp)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
            ) {
                Box(
                    modifier = Modifier.align(labelAlignment)
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
