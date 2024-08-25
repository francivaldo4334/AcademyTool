package br.com.pwrftctrl.app.presenter.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.lazy

object MyViewModelFactory : ViewModelProvider.Factory {

  private val modulesManagerViewModel by lazy { ModulesManagerViewModel() }
  private val profileManagerViewModel by lazy { ProfileManagerViewModel() }

  fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(ModulesManagerViewModel::class.java)) {
      return modulesManagerViewModel as T
    } else if (modelClass.isAssignableFrom(ProfileManagerViewModel::class.java)) {
      return profileManagerViewModel as T
    }

    throw IllegalArgumentException("Unknow  ViewModel class")
  }
}
