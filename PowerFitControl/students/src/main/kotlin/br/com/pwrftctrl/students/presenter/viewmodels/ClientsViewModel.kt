package br.com.pwrftctrl.students.presenter.viewmodels

import androidx.lifecycle.ViewModel
import br.com.pwrftctrl.students.presenter.enums.OptionsType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ClientsViewModel : ViewModel() {
    private val _selectedOption = MutableStateFlow(OptionsType.STUDENTS)
    val selectedOption: StateFlow<OptionsType> = _selectedOption.asStateFlow()
    fun selectOption(optionsType: OptionsType) {
        _selectedOption.update { optionsType }
    }
}
