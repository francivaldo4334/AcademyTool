package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table

object TrainingSheet: Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val registraion = integer("registraion").references(Registraion.id)
  val studentName = varchar("student_name", 255)
  //TODO
}
