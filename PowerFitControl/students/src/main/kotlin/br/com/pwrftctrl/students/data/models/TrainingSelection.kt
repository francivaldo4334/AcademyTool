package br.com.pwrftctrl.students.data.models

import org.jetbrains.exposed.sql.Table
import br.com.pwrftctrl.core.data.utils.weekdayField

object TrainingSelection: Table() {
  val id = integer("id").autoIncrement().entityId()
  val trainingId = integer("training_id").check { it greater 0}
  val trainingSheetId = integer("training_sheet_id").references(TrainingSheet.id)
  val weekday = weekdayField()
}
