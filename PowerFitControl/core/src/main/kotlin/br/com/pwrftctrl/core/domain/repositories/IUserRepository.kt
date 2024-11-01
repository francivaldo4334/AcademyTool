package br.com.pwrftctrl.core.domain.repositories

import br.com.pwrftctrl.core.domain.models.UserModel

interface IUserRepository {
  fun createNewUser(user: UserModel)
  fun updateUser(user: UserModel)
}
