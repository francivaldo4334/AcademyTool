package br.com.pwrftctrl.app.presenter.clients.header.viewmodels

import androidx.lifecycle.ViewModel
import br.com.pwrftctrl.app.presenter.clients.header.enums.OptionsType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ClientsManagerViewModel : ViewModel() {
  val _selectedOption = MutableStateFlow(OptionsType.STUDENTS)
  val selectedOption: StateFlow<OptionsType> = _selectedOption.asStateFlow()
  fun selectOption(optionsType: OptionsType) {
    _selectedOption.update { optionsType }
  }
}
