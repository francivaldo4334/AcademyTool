package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.models.Users

object TrainingSheet: Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val registration = integer("registration").references(Registration.id)
  val studentName = varchar("student_name", 255)
  val student = integer("student").references(Users.id)
  val instructor = integer("instructor").references(Users.id)
}
