package br.com.pwrftctrl.schedule.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.timeInMinutesField

class Unavailability: Table() {
  val id = integer("id").autoIncrement().entityId()
  val date = dateField("date")
  val startTime = timeInMinutesField("start_time")
  val endTime = timeInMinutesField("end_time")
  val availability = integer("availability").references(Availablity.id)
}
