package br.com.pwrftctrl.app.presenter.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.lazy

object MyViewModelFactory : ViewModelProvider.Factory {

  private val modulesManagerViewModel by lazy { ModulesManagerViewModel() }

  fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(ModulesManagerViewModel::class.java)) {
      return modulesManagerViewModel as T
    }

    throw IllegalArgumentException("Unknow  ViewModel class")
  }
}
