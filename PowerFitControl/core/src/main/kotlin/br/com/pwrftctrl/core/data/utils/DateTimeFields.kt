package br.com.pwrftctrl.core.data.utils

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.append

// Data formato YYYY/MM/dd contagem em dias
fun Table.dateField(name: String): Column<Long> {
  return long(name)
}

// DataHora formato YYYY/MM/dd HH:mm contagem em Minutos
fun Table.dateTimeField(name: String): Column<Long> {
  return long(name)
}

// Hora formato HH:mm contagem em Minutos em um intervalo de 0 a 24 horas
fun Table.timeInMinutesField(name: String): Column<Int> {
  return integer(name).check { (it greaterEq 0) and (it lessEq 24 * 60) }
}

// Hora formato HH:mm:ss contagem em segundos em um intervalo de 0 a 24 horas
fun Table.timeField(name: String): Column<Long> {
  return long(name).check { (it greaterEq 0) and (it lessEq 24 * 60 * 60) }
}

// Dia da semana como inicio index 0 Domingo
fun Table.weekdayField(name: String = "weekday"): Column<Int> {
  return integer(name).check { (it greaterEq 0) and (it lessEq 6) }
}

class CurrentDate : Expression<Long>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append("DATEDIFF(CURRENT_DATE(), '1970-01-01')")
  }
}

class CurrentTimeInMinutesTime : Expression<Int>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append(
            "EXTRACT(HOUR FROM CURRENT_TIMESTAMP) * 60 + EXTRACT(MINUTE FROM CURRENT_TIMESTAMP)"
    )
  }
}

class CurrentTime : Expression<Long>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append(
            "EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) - EXTRACT(EPOCH FROM DATE_TRUNC('day', CURRENT_TIMESTAMP))"
    )
  }
}
