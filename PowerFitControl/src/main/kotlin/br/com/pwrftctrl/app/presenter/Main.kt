package br.com.pwrftctrl.app.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import br.com.pwrftctrl.app.presenter.header.MainHeader
import br.com.pwrftctrl.app.presenter.sidebar.SideBar
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen
import br.com.pwrftctrl.core.presenter.ui.theme.AppTheme
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.screens.ClientsScreen
import com.composables.icons.lucide.Construction
import com.composables.icons.lucide.Lucide

@Composable
fun App() {
    val extendedColors = LocalExtendedColors.current
    var moduleSelected by remember { mutableStateOf(ModuleSelection.CLIENTS) }
    AppTheme() {
        Row(modifier = Modifier.fillMaxSize()) {
            SideBar(moduleSelected = moduleSelected, setModuleSelection = { moduleSelected = it })
            Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                MainHeader()
                Divider()
                // UI module manager
                when (moduleSelected) {
                    ModuleSelection.CLIENTS -> {
                        ClientsScreen()
                    }
                    else -> {
                        Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                        ) {
                            Box(
                                    modifier =
                                            Modifier.clip(RoundedCornerShape(12.dp))
                                                    .border(
                                                            4.dp,
                                                            extendedColors.primary500,
                                                            RoundedCornerShape(12.dp)
                                                    )
                                                    .background(extendedColors.primary100)
                                                    .padding(16.dp)
                            ) {
                                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                    Icon(
                                            imageVector = Lucide.Construction,
                                            contentDescription = "Em construção",
                                            modifier = Modifier.size(32.dp),
                                            tint = extendedColors.primary500,
                                    )
                                    Column {
                                        Text(
                                                text = "Modulo em Construção",
                                                fontSize = 24.sp,
                                                color = extendedColors.primary500,
                                        )
                                        Text(
                                                text =
                                                        "Desculpe o transtorno, estamos trabalhando pra entregar este modulo.",
                                                fontSize = 18.sp,
                                                color = extendedColors.primary500,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main() = application {
    var isFullscreen by remember { mutableStateOf(false) }
    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
            onCloseRequest = ::exitApplication,
            title = R.strings.app_name,
            state = windowState,
            onKeyEvent = {
                if (it.key == Key.F11 && it.type == KeyEventType.KeyUp) {
                    isFullscreen = !isFullscreen
                    windowState.placement =
                            if (isFullscreen) WindowPlacement.Fullscreen
                            else WindowPlacement.Floating
                    true
                } else {
                    false
                }
            }
    ) {
        window.minimumSize =
                java.awt.Dimension(
                        LocalDimensionsSizeScreen.defaultWidth,
                        LocalDimensionsSizeScreen.defaultHeight
                )
        App()
    }
}
