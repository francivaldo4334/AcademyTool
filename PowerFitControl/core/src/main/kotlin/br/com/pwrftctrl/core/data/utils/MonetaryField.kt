package br.com.pwrftctrl.core.data.utils

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

// Valor monetario com contagem em centavos
fun Table.centsField(name: String = "value"): Column<Int> {
  return integer(name).check { it greaterEq 0 }.default(0)
}
