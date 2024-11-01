package br.com.pwrftctrl.core.data.dao

import br.com.pwrftctrl.core.data.models.User
import br.com.pwrftctrl.core.data.models.Users
import br.com.pwrftctrl.core.data.models.map
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class UserDao : IBaseDao<User> {
  override fun getAll() = transaction { Users.select(Users.columns) }
  override fun getById(pk: Int) = transaction {
    Users.select(Users.columns).where { Users.id eq pk }.limit(1)
  }
  override fun insert(model: User): Int = transaction {
    (Users.insert { it.map(model) } get Users.id).value
  }
  override fun update(model: User) = transaction {
    Users.update({ Users.id eq model.id }) { it.map(model) }
  }
  override fun delete(pk: Int) = transaction { Users.deleteWhere { id eq pk } }
}
