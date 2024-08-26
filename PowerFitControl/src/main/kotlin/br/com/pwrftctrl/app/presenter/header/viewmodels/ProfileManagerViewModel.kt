package br.com.pwrftctrl.app.presenter.header.viewmodels

import androidx.lifecycle.ViewModel
import br.com.pwrftctrl.app.presenter.enums.ProfileType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// TODO: Refatorar viewmodel para modulo de authentication
class ProfileManagerViewModel : ViewModel() {
  private val _profileLogged = MutableStateFlow(ProfileType.ADMIN)
  private val _profileName = MutableStateFlow("Francivaldo Costa")
  val profileLogged: StateFlow<ProfileType> = _profileLogged.asStateFlow()
  val profileName: StateFlow<String> = _profileName.asStateFlow()

  fun getProfileName(profileType: ProfileType): String {
    return when (profileType) {
      ProfileType.ADMIN -> "Adiministrador"
      ProfileType.STUDENT -> "Aluno"
      ProfileType.INSTRUCTOR -> "Instrutor"
      ProfileType.ATTENDANT -> "Atendente"
    }
  }
}
