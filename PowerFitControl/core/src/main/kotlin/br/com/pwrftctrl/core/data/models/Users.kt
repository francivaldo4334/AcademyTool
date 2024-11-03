package br.com.pwrftctrl.core.data.models

import br.com.pwrftctrl.core.data.utils.CurrentDate
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.dateTimeField
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement

object Users : Table("users") {
  val id = integer("id").autoIncrement().entityId()
  val cpf = varchar("cpf", 11)
  val active = bool("active").default(true)
  val firstName = varchar("first_name", 80)
  val lastName = varchar("last_name", 80)
  val email = varchar("email", 80)
  val registrationDate = dateTimeField("registration_date").defaultExpression(CurrentDate())
  val dateOfBirth = dateField("date_of_birth")
  val gender = varchar("gender", 50)
  val phone1 = varchar("phone_1", 15)
  val phone2 = varchar("phone_2", 15)
  val whatsapp = varchar("whatsapp", 15)
  val photo = varchar("photo", 255)
  val addressString = varchar("address_string", 255)
  val neighborhood = varchar("neighborhood", 120)
  val zipCode = varchar("zip_code", 50)
  val city = varchar("city", 50)
  val lastLogin = dateTimeField("last_login").nullable()
  val hash = varchar("hash", 64).nullable()
}

data class User(
        val id: Int,
        val cpf: String,
        val active: Boolean,
        val firstName: String,
        val lastName: String,
        val email: String,
        val registrationDate: Long,
        val dateOfBirth: Long,
        val gender: String,
        val phone1: String,
        val phone2: String,
        val whatsapp: String,
        val photo: String,
        val addressString: String,
        val neighborhood: String,
        val zipCode: String,
        val city: String,
        val lastLogin: Long?,
        val hash: String?,
)

fun InsertStatement<Number>.map(model: User) {
  this[Users.id] = model.id
  this[Users.cpf] = model.cpf
  this[Users.firstName] = model.firstName
  this[Users.lastName] = model.lastName
  this[Users.email] = model.email
  this[Users.dateOfBirth] = model.dateOfBirth
  this[Users.gender] = model.gender
  this[Users.phone1] = model.phone1
  this[Users.phone2] = model.phone2
  this[Users.whatsapp] = model.whatsapp
  this[Users.photo] = model.photo
  this[Users.addressString] = model.addressString
  this[Users.neighborhood] = model.neighborhood
  this[Users.zipCode] = model.zipCode
  this[Users.city] = model.city
  this[Users.lastLogin] = model.lastLogin
  this[Users.hash] = model.hash
}

fun UpdateStatement.map(model: User) {
  this[Users.cpf] = model.cpf
  this[Users.active] = model.active
  this[Users.firstName] = model.firstName
  this[Users.lastName] = model.lastName
  this[Users.email] = model.email
  this[Users.dateOfBirth] = model.dateOfBirth
  this[Users.gender] = model.gender
  this[Users.phone1] = model.phone1
  this[Users.phone2] = model.phone2
  this[Users.whatsapp] = model.whatsapp
  this[Users.photo] = model.photo
  this[Users.addressString] = model.addressString
  this[Users.neighborhood] = model.neighborhood
  this[Users.zipCode] = model.zipCode
  this[Users.city] = model.city
  this[Users.lastLogin] = model.lastLogin
  this[Users.hash] = model.hash
}
