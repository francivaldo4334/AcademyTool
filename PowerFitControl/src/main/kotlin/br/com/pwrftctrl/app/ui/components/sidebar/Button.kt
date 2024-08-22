package br.com.pwrftctrl.app.ui.components.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import br.com.pwrftctrl.app.ui.theme.LocalExtendedColors

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Button() {
        val extendedColors = LocalExtendedColors.current
        var isHovered = remember { mutableStateOf(false) }
        Box {
                Button(
                        onClick = {},
                        contentPadding = PaddingValues(8.dp),
                        colors =
                                ButtonDefaults.buttonColors(
                                        backgroundColor =
                                                if (isHovered.value) extendedColors.secondary800
                                                else Color.Transparent
                                ),
                        modifier =
                                Modifier.onPointerEvent(PointerEventType.Enter) {
                                        isHovered.value = true
                                }
                                        .onPointerEvent(PointerEventType.Exit) {
                                                isHovered.value = false
                                        }
                ) { Box(modifier = Modifier.size(24.dp)) }
                if (isHovered.value) {
                        Popup(
                                alignment = Alignment.TopStart,
                                properties =
                                        PopupProperties(
                                                dismissOnBackPress = true,
                                                dismissOnClickOutside = true,
                                        )
                        ) {
                                Box(
                                        modifier =
                                                Modifier.background(
                                                                color = extendedColors.secondary50
                                                        )
                                                        .clip(CircleShape)
                                                        .padding(8.dp)
                                ) { Text("okdfs") }
                        }
                }
        }
}
