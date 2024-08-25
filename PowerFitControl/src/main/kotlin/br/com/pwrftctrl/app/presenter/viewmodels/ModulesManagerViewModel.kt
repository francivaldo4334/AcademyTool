package br.com.pwrftctrl.app.presenter.viewmodels

import androidx.lifecycle.ViewModel
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ModulesManagerViewModel : ViewModel() {
  private val _moduleSelected = MutableStateFlow<ModuleSelection>(ModuleSelection.CLIENTS)
  val moduleSelected: StateFlow<ModuleSelection> = _moduleSelected
  fun selecteModule(module: ModuleSelection) {
    _moduleSelected.update { module }
  }
}
