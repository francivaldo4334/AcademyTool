package br.com.pwrftctrl.app.presenter.header

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.components.CompanyLogo

@Composable
fun Logo() {
    CompanyLogo(modifier = Modifier.size(40.dp))
}
