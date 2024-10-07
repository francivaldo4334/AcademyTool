package br.com.pwrftctrl.core.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateTimeField
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.CurrentDate

object User: Table() {
  val id = integer("id").autoIncrement().entityId()
  val cpf = varchar("cpf", 11)
  val active = bool("active").default(true)
  val firstName = varchar("firt_name", 80)
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
  val zipCode = varchar("zip_code",50)
  val city = varchar("city", 50)
  val lastLogin = dateTimeField("last_login")
  val hash = varchar("hash", 64)
}
