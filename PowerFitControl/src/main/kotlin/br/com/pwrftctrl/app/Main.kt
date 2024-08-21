package br.com.pwrftctrl.app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import br.com.pwrftctrl.app.ui.components.sidebar.SideBar
import br.com.pwrftctrl.core.utils.StringResources as R

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme { Row(modifier = Modifier.fillMaxSize()) { SideBar() } }
}

fun main() = application {
    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
            onCloseRequest = ::exitApplication,
            title = R.getString("app_name"),
            state = windowState,
            undecorated = true,
    ) {
        window.minimumSize = java.awt.Dimension(800, 600)
        App()
    }
}
