package br.com.powerfitctrl.app

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.powerfitctrl.core.utils.StringResources

@Composable
fun App() {
    Text(StringResources.getString("app_name"))
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = StringResources.getString("app_name")) {
        App()
    }
}
