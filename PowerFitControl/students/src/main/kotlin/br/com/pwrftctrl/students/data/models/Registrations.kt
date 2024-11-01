package br.com.pwrftctrl.students.data.models

import br.com.pwrftctrl.core.data.models.Users
import br.com.pwrftctrl.core.data.utils.CurrentDate
import br.com.pwrftctrl.core.data.utils.dateField
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement

object Registrations : Table() {
  val id = integer("id").autoIncrement().entityId()
  val active = bool("active").default(true)
  val student = integer("student").references(Users.id)
  val registrationDate = dateField("reistraion_date").defaultExpression(CurrentDate())
  val startDate = dateField("start_date")
  val dueDate = dateField("end_date")
  val situation = varchar("situation", 120)
  val modality = integer("modality").references(Modality.id)
  val observation = varchar("observation", 255)
  val inDebit = bool("in_debit").default(false)
}

data class Registration(
        val id: Int,
        val active: Boolean,
        val student: Int,
        val registrationDate: Long,
        val startDate: Long,
        val dueDate: Long,
        val situation: String,
        val modality: Int,
        val observation: String,
        val inDebit: Boolean,
)

fun InsertStatement<Number>.map(model: Registration) {
  this[Registrations.id] = model.id
  this[Registrations.active] = model.active
  this[Registrations.student] = model.student
  this[Registrations.startDate] = model.startDate
  this[Registrations.dueDate] = model.dueDate
  this[Registrations.situation] = model.situation
  this[Registrations.modality] = model.modality
  this[Registrations.observation] = model.observation
}

fun UpdateStatement.map(model: Registration) {
  this[Registrations.active] = model.active
  this[Registrations.student] = model.student
  this[Registrations.startDate] = model.startDate
  this[Registrations.dueDate] = model.dueDate
  this[Registrations.situation] = model.situation
  this[Registrations.modality] = model.modality
  this[Registrations.observation] = model.observation
  this[Registrations.inDebit] = model.inDebit
}
