package br.com.powerfitctrl.app.presenter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.powerfitctrl.app.presenter.viewmodels.CommonViewModel
import br.com.powerfitctrl.app.presenter.viewmodels.enums.ModuleSelected
import br.com.powerfitctrl.core.presenter.ui.secondary_900

@Composable
fun SideBar(commonViewModel: CommonViewModel = viewModel()) {

  Box(modifier = Modifier.fillMaxHeight().width(56.dp).background(secondary_900)) {
    Column(modifier = Modifier.align(Alignment.Center)) {
      ButtonSelectModule(selected = commonViewModel.moduleSelected.value == ModuleSelected.CLIENTS)
      ButtonSelectModule(selected = false)
      ButtonSelectModule(selected = false)
    }
    ButtonSelectModule(selected = false, modifier = Modifier.align(Alignment.BottomCenter))
  }
}
