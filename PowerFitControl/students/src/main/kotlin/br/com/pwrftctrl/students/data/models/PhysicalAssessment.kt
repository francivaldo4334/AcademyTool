package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.models.Users

class PhysicalAssessment: Table() {
  val id = integer("id").autoIncrement().entityId()
  val student = integer("student").references(Users.id)
  val instructor = varchar("instructor", 11)
  val date = dateField("date")
  val heartRate = integer("heart_rate")
  val studentWeight = integer("student_weight")
  val height = integer("height")
  val abdominal = integer("abdominal")
  val armFlexion = integer("arm_flexion")
  val anthropometry = integer("anthropometry").references(Anthropometry.id)
  val skinFold = integer("skin_fold").references(SkinFold.id)
  val diameter = integer("diameter").references(Diameter.id)
  val circumference = integer("circumference").references(Circumference.id)
}
