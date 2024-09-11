package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table

object Anthropometry: Table() {
  val id = integer("id").autoIncrement().entityId()
  val neck = double("neck")
  val thoracic = double("thoracic")
  val waist = double("waist")
  val hip = double("hip")
  val relaxedArm = double("relaxed_arm")
  val contractedArm = double("contracted_arm")
  val forearm = double("forearm")
  val upperThigh = double("upper_thigh")
  val middleThigh = double("middle_thigh")
  val lowerThigh = double("lower_thigh")
  val leg = double("log")
}
