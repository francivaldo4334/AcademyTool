package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.timeInMinutesField
import br.com.pwrftctrl.core.data.utils.CurrentDate
import br.com.pwrftctrl.core.data.utils.CurrentTimeInMinutesTime

object Frequency: Table() {
  val id = integer("id").autoIncrement().entityId()
  val registration = integer("registration").references(Registration.id)
  val student = varchar("student", 11).references(Registration.student)
  val date = dateField("date").defaultExpression(CurrentDate())
  val enter = timeInMinutesField("enter").defaultExpression(CurrentTimeInMinutesTime())
  val exit = timeInMinutesField("enter").defaultExpression(CurrentTimeInMinutesTime())
}
