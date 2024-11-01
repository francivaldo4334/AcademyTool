package br.com.pwrftctrl.core.domain.repositories

import br.com.pwrftctrl.core.data.MyDatabase
import br.com.pwrftctrl.core.data.dao.UserDao
import br.com.pwrftctrl.core.domain.models.UserModel
import br.com.pwrftctrl.core.domain.models.toDaoModel

class UserRepository(
        val db: MyDatabase = MyDatabase,
        val userDao: UserDao = UserDao(),
) : IUserRepository {
  override fun createNewUser(user: UserModel) {
    userDao.insert(user.toDaoModel())
  }

  override fun updateUser(user: UserModel) {
    userDao.update(user.toDaoModel())
  }
}
