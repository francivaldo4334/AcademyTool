package br.com.pwrftctrl.core.data.utils

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.QueryBuilder
import org.jetbrains.exposed.sql.append

fun Table.dateField(name: String): Column<Long> {
  return long(name)
}

fun Table.dateTimeField(name: String): Column<Long> {
  return long(name)
}

fun Table.timeInMinutesField(name: String): Column<Int> {
  return integer(name).check { (it greaterEq 0) and (it lessEq 24)}
}

fun Table.timeField(name: String): Column<Long> {
  return long(name)
}

fun Table.centsField(name: String = "value"): Column<Int> {
  return integer(name).check { it greaterEq 0}.default(0)
}

fun Table.weekdayField(name: String = "weekday"): Column<Int> {
  //Idex 0 iqual a Domingo
  return integer(name).check { (it greaterEq 0) and (it lessEq 6)}
}

class CurrentDate : Expression<Long>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append("DATEDIFF(CURRENT_DATE(), '1970-01-01')")
  }
}

class CurrentTimeInMinutesTime: Expression<Int>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append("EXTRACT(HOUR FROM CURRENT_TIMESTAMP) * 60 + EXTRACT(MINUTE FROM CURRENT_TIMESTAMP)")
  }
}

class CurrentTime: Expression<Long>() {
  override fun toQueryBuilder(queryBuilder: QueryBuilder) {
    queryBuilder.append("EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) - EXTRACT(EPOCH FROM DATE_TRUNC('day', CURRENT_TIMESTAMP))")
  }
}
