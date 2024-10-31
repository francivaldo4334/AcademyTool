package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table

object Circumference : Table() {
  val id = integer("id").autoIncrement().entityId()
  val gluteus = double("gluteus")
  val calf = double("calf")
  val malleolar = double("malleolar")
  val stemIM = double("stem_im")
  val stemEM = double("stem_em")
}
