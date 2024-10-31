package br.com.pwrftctrl.students.presenter.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import br.com.pwrftctrl.core.presenter.ui.components.BaseStatusCounter
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R
import br.com.pwrftctrl.students.presenter.enums.StudentStateFilter
import com.composables.icons.lucide.BookmarkCheck
import com.composables.icons.lucide.BookmarkX
import com.composables.icons.lucide.Cake
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserX

@Composable
fun StatusCounter(status: StudentStateFilter, count: Int) {
  val extendedColors = LocalExtendedColors.current
  when (status) {
    StudentStateFilter.NO_PAID -> {
      BaseStatusCounter(
              backgroundColor = extendedColors.red100,
              tint = extendedColors.red900,
              painter = rememberVectorPainter(Lucide.BookmarkX),
              count = count.toString(),
              textTip = R.strings.in_debt,
      )
    }
    StudentStateFilter.PAID -> {
      BaseStatusCounter(
              backgroundColor = extendedColors.green100,
              painter = rememberVectorPainter(Lucide.BookmarkCheck),
              tint = extendedColors.green900,
              count = count.toString(),
              textTip = R.strings.checked,
      )
    }
    StudentStateFilter.BIRTHDAY -> {
      BaseStatusCounter(
              backgroundColor = extendedColors.yellow100,
              painter = rememberVectorPainter(Lucide.Cake),
              tint = extendedColors.yellow900,
              count = count.toString(),
              textTip = R.strings.birthday,
      )
    }
    StudentStateFilter.MISSING -> {
      BaseStatusCounter(
              backgroundColor = extendedColors.blue100,
              painter = rememberVectorPainter(Lucide.UserX),
              tint = extendedColors.blue900,
              count = count.toString(),
              textTip = R.strings.missing,
      )
    }
    StudentStateFilter.NONE -> {}
  }
}
