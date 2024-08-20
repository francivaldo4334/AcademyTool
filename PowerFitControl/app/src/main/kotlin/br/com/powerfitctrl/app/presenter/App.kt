package br.com.powerfitctrl.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import br.com.powerfitctrl.app.presenter.component.SideBar
import br.com.powerfitctrl.core.presenter.ui.*
import br.com.powerfitctrl.core.utils.StringResources

fun main() = application {
    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
            onCloseRequest = ::exitApplication,
            title = StringResources.getString("app_name"),
            state = windowState,
            undecorated = true,
    ) {
        window.minimumSize = java.awt.Dimension(800, 600)
        App()
    }
}

@Composable
fun App() {
    Box(modifier = Modifier.fillMaxSize().background(white)) { SideBar() }
}
