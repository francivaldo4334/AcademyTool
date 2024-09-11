package br.com.pwrftctrl.clients.data.models

import org.jetbrains.exposed.sql.Table

object Diameter: Table() {
  val id = integer("id").autoIncrement().entityId()
  val humeral = double("humeral")
  val radioUlnarDiameter = double("radio_ulnar_diameter")
  val bicrominal = double("bicrominal")
  val transverseThoracic = double("transverse_thoracic")
  val laterThoracic = double("later_thoracic")
  val previousThoracic = double("previous_thoracic")
  val bicrystal = double("bicrystal")
  val femur = double("femur")
  val malleolar = double("malleolar")
}
