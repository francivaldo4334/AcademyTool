package br.com.pwrftctrl.app.presenter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import br.com.pwrftctrl.app.presenter.header.MainHeader
import br.com.pwrftctrl.app.presenter.sidebar.SideBar
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import br.com.pwrftctrl.core.utils.R as R
import br.com.pwrftctrl.core.presenter.ui.theme.AppTheme
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen
import br.com.pwrftctrl.clients.presenter.screens.ClientsScreen


@Composable
fun App() {
    var moduleSelected by remember {
        mutableStateOf(ModuleSelection.CLIENTS)
    }
    AppTheme() {
        Row(modifier = Modifier.fillMaxSize()) {
            SideBar(
                moduleSelected = moduleSelected,
                setModuleSelection = {
                    moduleSelected = it
                }
            )
            Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                MainHeader()
                Divider()
                // UI module manager
                when(moduleSelected) {
                    ModuleSelection.CLIENTS -> {
                        ClientsScreen()
                    }
                    else -> {}
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