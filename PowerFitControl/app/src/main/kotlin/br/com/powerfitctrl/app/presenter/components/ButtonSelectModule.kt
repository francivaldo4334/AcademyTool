package br.com.powerfitctrl.app.presenter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSelectModule(modifier: Modifier? = null) {
  Box(modifier = Modifier.size(30.dp).background(Color(0xFFFF)))
}
