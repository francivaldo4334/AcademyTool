package br.com.pwrftctrl.students.presenter.components

import androidx.compose.runtime.Composable
import br.com.pwrftctrl.students.presenter.enums.StudentStateFilter
import br.com.pwrftctrl.core.presenter.ui.components.BaseStatusCounter
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

@Composable
fun StatusCounter(status: StudentStateFilter, count: Int) {
  val extendedColors = LocalExtendedColors.current
  when (status) {
    StudentStateFilter.NO_PAID -> {
      BaseStatusCounter(
        backgroundColor = extendedColors.red100,
        tint = extendedColors.red900,
        painter = R.vectors.ic_no_money,
        count = count.toString()
      )
    }
    StudentStateFilter.PAID -> {
      BaseStatusCounter(
        backgroundColor = extendedColors.green100,
        painter = R.vectors.ic_money,
        tint = extendedColors.green900,
        count = count.toString()
      )
    }
    StudentStateFilter.BIRTHDAY -> {
      BaseStatusCounter(
        backgroundColor = extendedColors.yellow100,
        painter = R.vectors.ic_cake,
        tint = extendedColors.yellow900,
        count = count.toString()
      )
    }
    StudentStateFilter.MISSING -> {
      BaseStatusCounter(
        backgroundColor = extendedColors.blue100,
        painter = R.vectors.ic_question,
        tint = extendedColors.blue900,
        count = count.toString()
      )
    }
    StudentStateFilter.NONE -> {}
  }
}
