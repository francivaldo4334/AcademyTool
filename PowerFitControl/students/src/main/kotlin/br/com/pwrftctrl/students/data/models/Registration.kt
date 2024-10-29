package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.CurrentDate
import br.com.pwrftctrl.core.data.models.Users

object Registration : Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val student = integer("student").references(Users.id)
  val registrationDate = dateField("reistraion_date").defaultExpression(CurrentDate())
  val startDate = dateField("start_date")
  val dueDate = dateField("end_date")
  val situation = varchar("situation", 120)
  val modality = integer("modality").references(Modality.id)
  val observation = varchar("observation", 255)
  val inDebit = bool("in_debit").default(false)
}
