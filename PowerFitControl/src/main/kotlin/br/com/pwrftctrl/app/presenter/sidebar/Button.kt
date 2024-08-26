package br.com.pwrftctrl.app.presenter.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import br.com.pwrftctrl.app.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.app.presenter.viewmodels.ModulesManagerViewModel
import br.com.pwrftctrl.app.presenter.viewmodels.MyViewModelFactory
import kotlin.math.roundToInt

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Button(
        iconPainter: Painter,
        textHelp: String,
        moduleIndex: ModuleSelection,
        moduleSelected: ModuleSelection,
        modifier: Modifier = Modifier
) {
        val modulesManagerViewModel = MyViewModelFactory.create(ModulesManagerViewModel::class.java)
        val extendedColors = LocalExtendedColors.current
        var isHovered = remember { mutableStateOf(false) }
        var buttomPosition = remember { mutableStateOf(IntOffset.Zero) }
        Box(modifier = modifier.wrapContentSize()) {
                Button(
                        onClick = { modulesManagerViewModel.selecteModule(moduleIndex) },
                        contentPadding = PaddingValues(8.dp),
                        colors =
                                ButtonDefaults.buttonColors(
                                        backgroundColor =
                                                if (moduleIndex == moduleSelected)
                                                        extendedColors.primary500
                                                else if (isHovered.value)
                                                        extendedColors.secondary800
                                                else Color.Transparent
                                ),
                        modifier =
                                Modifier.onPointerEvent(PointerEventType.Enter) {
                                        isHovered.value = true
                                }
                                        .onPointerEvent(PointerEventType.Exit) {
                                                isHovered.value = false
                                        }
                                        .onGloballyPositioned { coodinates ->
                                                buttomPosition.value =
                                                        coodinates.positionInWindow().run {
                                                                IntOffset(
                                                                        x.roundToInt(),
                                                                        y.roundToInt()
                                                                )
                                                        }
                                        },
                        shape = RoundedCornerShape(12.dp)
                ) {
                        Icon(
                                painter = iconPainter,
                                contentDescription = "Icon Module $textHelp",
                                modifier = Modifier.size(24.dp),
                                tint = extendedColors.white
                        )
                }
                if (isHovered.value) {
                        Popup(
                                alignment = Alignment.TopStart,
                                properties =
                                        PopupProperties(
                                                dismissOnBackPress = true,
                                                dismissOnClickOutside = true,
                                        ),
                                offset = IntOffset(buttomPosition.value.x + 56, 4)
                        ) {
                                Box(
                                        modifier =
                                                Modifier.clip(RoundedCornerShape(12.dp))
                                                        .background(
                                                                color = extendedColors.secondary100
                                                        )
                                                        .padding(8.dp)
                                ) { Text(textHelp) }
                        }
                }
        }
}
