package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table

object SkinFold: Table() {
  val id = integer("id").autoIncrement().entityId()
}
