package br.com.pwrftctrl.schedule.data.models

import br.com.pwrftctrl.core.data.utils.dateField
import br.com.pwrftctrl.core.data.utils.timeInMinutesField
import org.jetbrains.exposed.sql.Table

object Availablity : Table() {
  val id = integer("id").autoIncrement().entityId()
  val assignedObjectSlug = varchar("assigned_object", 80)
  val startDate = dateField("start_date")
  val endDate = dateField("end_date")
  val startTime = timeInMinutesField("start_time")
  val endTime = timeInMinutesField("end_time")
  val slotDuration = timeInMinutesField("slot_duration")
  val slotInterval = timeInMinutesField("slot_interval")
}
