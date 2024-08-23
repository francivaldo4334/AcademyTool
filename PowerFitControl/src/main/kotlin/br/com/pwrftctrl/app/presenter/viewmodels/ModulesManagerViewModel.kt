package br.com.pwrftctrl.app.presenter.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.asStateFlow
import br.com.pwrftctrl.app.presenter.ui.enums.ModuleSelection

class ModulesManagerViewModel : ViewModel() {
  private val _moduleSelected = MutableStateFlow<ModuleSelection>(ModuleSelection.CLIENTS)
  val moduleSelected = _moduleSelected.asStateFlow()
  fun selecteModule(module: ModuleSelection) {
      _moduleSelected.update{
        module
      }
  }
}
