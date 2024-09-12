package br.com.pwrftctrl.schedule.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.timeInMinutesField
import br.com.pwrftctrl.core.data.utils.dateTimeField

class Schedule: Table() {
  val id = integer("id").autoIncrement().entityId()
  val scheduledObjectSlug = varchar("scheduled_object", 80)
  val status = varchar("status", 80)
  val duration = timeInMinutesField("duration")
  val dateTime = dateTimeField("date_time")
  val fitFlag = bool("fit_flag")
}
