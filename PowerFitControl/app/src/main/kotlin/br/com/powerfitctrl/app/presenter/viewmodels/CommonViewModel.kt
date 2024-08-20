package br.com.powerfitctrl.app.presenter.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import br.com.powerfitctrl.app.presenter.viewmodels.enums.ModuleSelected

class CommonViewModel : ViewModel() {
  var moduleSelected = mutableStateOf(ModuleSelected.SETTINGS)
}
