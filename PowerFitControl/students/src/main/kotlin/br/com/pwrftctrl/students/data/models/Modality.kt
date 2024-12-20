package br.com.pwrftctrl.students.data.models

import br.com.pwrftctrl.core.data.utils.centsField
import org.jetbrains.exposed.sql.Table

object Modality : Table() {
  val id = integer("id").autoIncrement().entityId()
  val value = centsField()
  val description = varchar("description", 255)
  val paymentMethod = varchar("paymento_method", 255)
  val active = bool("active").default(true)
}
