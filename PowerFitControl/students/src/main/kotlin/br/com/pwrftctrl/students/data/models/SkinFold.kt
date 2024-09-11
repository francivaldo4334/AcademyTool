package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table

object SkinFold: Table() {
  val id = integer("id").autoIncrement().entityId()
  val subscapularis = double("subscapularis")
  val triceps = double("triceps")
  val biceps = double("biceps")
  val pectoral = double("pectoral")
  val obliqueMiddleArmpit = double("oblique_middle_armpit")
  val verticalMiddleArmpit = double("verticalMiddleArmpit")
  val horizontalAbdominal = double("horizontal_abdominal")
  val verticalAbdominal = double("vertical_abdominal")
  val obliqueSuprailiac = double("oblique_suprailiac")
  val verticalSuprailiac = double("vertical_suprailiac")
  val supraexpinal = double("supraexpinal")
}
