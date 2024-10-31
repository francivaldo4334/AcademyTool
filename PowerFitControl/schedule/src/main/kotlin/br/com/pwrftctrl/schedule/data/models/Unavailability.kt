package br.com.pwrftctrl.schedule.data.models

import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.timeInMinutesField
import org.jetbrains.exposed.sql.Table

class Unavailability : Table() {
  val id = integer("id").autoIncrement().entityId()
  val date = dateField("date")
  val startTime = timeInMinutesField("start_time")
  val endTime = timeInMinutesField("end_time")
  val availability = integer("availability").references(Availablity.id)
}
