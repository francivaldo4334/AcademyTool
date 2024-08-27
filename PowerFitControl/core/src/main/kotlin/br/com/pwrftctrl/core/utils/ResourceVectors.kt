package br.com.pwrftctrl.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

class ResourceVectors() {
    val ic_clients: Painter
        @Composable
        get() {
            return R.getVector("ic_clients.svg")
        }
    val ic_dumbbells: Painter
        @Composable
        get() {
            return R.getVector("ic_dumbbells.svg")
        }
    val ic_hand_money: Painter
        @Composable
        get() {
            return R.getVector("ic_hand_money.svg")
        }
    val ic_status_up: Painter
        @Composable
        get() {
            return R.getVector("ic_status_up.svg")
        }
    val ic_logout: Painter
        @Composable
        get() {
            return R.getVector("ic_logout.svg")
        }
    val ic_settings: Painter
        @Composable
        get() {
            return R.getVector("ic_settings.svg")
        }
}
