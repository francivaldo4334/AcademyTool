package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table

object Client: Table() {
  val id = integer("id").autoIncrement().entityId()
  val cpf = varchar("cpf", 11).uniqueIndex()
  val inDebit = bool("in_debit").default(false)
  val name = varchar("name", 255, "NOCASE")
}
