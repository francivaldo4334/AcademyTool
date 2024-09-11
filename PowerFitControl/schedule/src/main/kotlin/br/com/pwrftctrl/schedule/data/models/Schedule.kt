package br.com.pwrftctrl.schedule.data.models

import org.jetbrains.exposed.sql.Table

class Schedule: Table() {
  val id = integer("id").autoIncrement().entityId()
}
