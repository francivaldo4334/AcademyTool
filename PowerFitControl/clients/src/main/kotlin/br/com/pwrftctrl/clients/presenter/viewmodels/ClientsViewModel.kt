package br.com.pwrftctrl.clients.presenter.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import br.com.pwrftctrl.clients.presenter.enums.OptionsType

class ClientsViewModel : ViewModel() {
  private val _selectedOption = MutableStateFlow(OptionsType.STUDENTS)
  val selectedOption: StateFlow<OptionsType> = _selectedOption.asStateFlow()
  fun selectOption(optionsType: OptionsType) {
    _selectedOption.update { optionsType }
  }
}
