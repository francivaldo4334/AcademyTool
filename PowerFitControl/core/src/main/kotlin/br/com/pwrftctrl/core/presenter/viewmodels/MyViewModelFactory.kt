package br.com.pwrftctrl.core.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object MyViewModelFactory : ViewModelProvider.Factory {

    private val viewModelInstances = mutableMapOf<Class<*>, ViewModel>()

    @Suppress("UNCHECKED_CAST")
    fun <T : ViewModel> create(modelClass: Class<T>): T {

        return viewModelInstances.getOrPut(modelClass) {
            modelClass.getDeclaredConstructor().newInstance()
        }.let {
            if (modelClass.isInstance(it)) it as T
            else throw IllegalArgumentException("Unknow  ViewModel class")

        }
    }
}

inline fun <reified T : ViewModel> viewModel(): T = MyViewModelFactory.create(T::class.java)
