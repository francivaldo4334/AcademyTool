package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun PopoverTip(
    alignment: Alignment = Alignment.TopStart,
    offset: IntOffset = IntOffset(0, 0),
    contentComponent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val extendedColors = LocalExtendedColors.current
    var isHover by remember { mutableStateOf(false) }
    var tipWidth by remember { mutableStateOf(0) }
    var tipHeight by remember { mutableStateOf(0) }
    var contentWidth by remember { mutableStateOf(0) }
    var contentHeight by remember { mutableStateOf(0) }
    Box {
        Box(modifier = Modifier
            .onPointerEvent(PointerEventType.Enter) { isHover = true }
            .onPointerEvent(PointerEventType.Exit) { isHover = false }
            .drawBehind {
                contentWidth = size.width.toInt()
                contentHeight = size.height.toInt()
            }
        ) {
            contentComponent()
        }
        Popup(
            alignment = Alignment.TopStart,
            properties = PopupProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            ),
            offset = when (alignment) {
                Alignment.CenterEnd -> IntOffset(offset.x + contentWidth, (contentHeight - tipHeight) / 2 + offset.y)
                Alignment.TopEnd -> IntOffset(offset.x + contentWidth, offset.y)
                Alignment.BottomCenter -> IntOffset(-(tipWidth - contentWidth) / 2 + offset.x, contentHeight + offset.y)
                Alignment.BottomStart -> IntOffset(offset.x, contentHeight + offset.y)
                else -> offset
            }
        ) {
            AnimatedVisibility(
                visible = isHover,
                enter = scaleIn() + expandIn() + fadeIn(),
                exit = scaleOut() + shrinkOut() + fadeOut(),
            ) {
                Box(
                    modifier = Modifier
                        .drawBehind {
                            tipWidth = size.width.toInt()
                            tipHeight = size.height.toInt()
                        }
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            color = extendedColors.secondary300.copy(0.5f)
                        )
                        .padding(4.dp)
                ) {
                    content()
                }
            }
        }
    }
}
