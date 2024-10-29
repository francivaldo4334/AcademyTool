package br.com.pwrftctrl.core.data.dao

import br.com.pwrftctrl.core.data.models.Users
import br.com.pwrftctrl.core.data.models.User
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import br.com.pwrftctrl.core.data.models.map
class UserDao {
  fun getById(pk: Int) = transaction {
    Users.select(Users.columns).where{Users.id eq pk}.limit(1)
  }
  fun insert(model: User): Int {
    return (Users.insert{
      it.map(model)
    } get Users.id).value
  }
  fun update(model: User){
    Users.update({Users.id eq model.id}){
      it.map(model) 
    }
  }
  fun delete(pk: Int) = transaction {
    Users.deleteWhere{id eq pk }
  }
}
