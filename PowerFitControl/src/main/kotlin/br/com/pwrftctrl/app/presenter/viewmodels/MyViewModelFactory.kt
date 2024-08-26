package br.com.pwrftctrl.app.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.pwrftctrl.app.presenter.header.viewmodels.ProfileManagerViewModel
import br.com.pwrftctrl.app.presenter.clients.header.viewmodels.ClientsManagerViewModel
import kotlin.lazy

object MyViewModelFactory : ViewModelProvider.Factory {

  private val modulesManagerViewModel by lazy { ModulesManagerViewModel() }
  private val profileManagerViewModel by lazy { ProfileManagerViewModel() }
  private val clientsManagerViewModel by lazy { ClientsManagerViewModel() }

  fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(ModulesManagerViewModel::class.java)) {
      return modulesManagerViewModel as T
    } else if (modelClass.isAssignableFrom(ProfileManagerViewModel::class.java)) {
      return profileManagerViewModel as T
    } else if (modelClass.isAssignableFrom(ClientsManagerViewModel::class.java)) {
      return clientsManagerViewModel as T
    }

    throw IllegalArgumentException("Unknow  ViewModel class")
  }
}
