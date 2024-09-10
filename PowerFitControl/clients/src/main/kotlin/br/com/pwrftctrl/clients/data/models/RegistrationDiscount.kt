package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.centsField

object RegistrationDiscount: Table() {
  val id = integer("id").autoIncrement().entityId()
  val value = centsField()
  val description = varchar("description", 255)
  val registration = integer("registration").references(Registration.id)
}
