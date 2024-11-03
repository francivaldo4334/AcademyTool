package br.com.pwrftctrl.core.domain.utils

import java.time.LocalDate
import java.time.temporal.ChronoUnit

private val EPOCH_DATE = LocalDate.of(1970, 1, 1)

fun LocalDate.toDateTimeMinutes(): Long {
  return ChronoUnit.MINUTES.between(EPOCH_DATE, this)
}

fun LocalDate.toDateDays(): Long {
  return ChronoUnit.DAYS.between(EPOCH_DATE, this)
}
