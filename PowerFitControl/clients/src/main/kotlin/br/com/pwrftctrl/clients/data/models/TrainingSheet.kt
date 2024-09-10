package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table

object TrainingSheet: Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val registration = integer("registration").references(Registration.id)
  val studentName = varchar("student_name", 255)
  val instructor = varchar("instructor", 11)
}
