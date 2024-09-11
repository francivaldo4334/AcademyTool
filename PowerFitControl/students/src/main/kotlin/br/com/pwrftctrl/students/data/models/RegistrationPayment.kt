package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table

object RegistrationPayment: Table() {
  val id = integer("id").autoIncrement().entityId()
  val paymentCode = integer("payment_code").uniqueIndex()
  val registration = integer("registraion").references(Registration.id)
}
