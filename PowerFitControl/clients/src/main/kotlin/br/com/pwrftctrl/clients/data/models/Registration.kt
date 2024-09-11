package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.CurrentDate

object Registration : Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val student = varchar("student", 11).uniqueIndex()
  val registrationDate = dateField("reistraion_date").defaultExpression(CurrentDate())
  val startDate = dateField("start_date")
  val dueDate = dateField("end_date")
  val situation = varchar("situation", 120)
  val modality = integer("modality").references(Modality.id)
  val observation = varchar("observation", 255)
  val inDebit = bool("in_debit").default(false)
}
