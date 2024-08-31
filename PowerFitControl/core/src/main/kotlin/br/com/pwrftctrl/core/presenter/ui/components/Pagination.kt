package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

private const val COUNT_REPEAT = 9
private const val START = 0
private const val END = COUNT_REPEAT - 1

@Composable
inline private fun DirectionButton(
        painter: Painter,
        enable: Boolean,
        value: Int,
        crossinline onChange: (Int) -> Unit,
) {
  val extendedColors = LocalExtendedColors.current
  PaginationButton(onClick = { onChange(value) }, enable = enable) {
    Icon(
            painter = painter,
            contentDescription = "",
            tint = if (enable) extendedColors.secondary900 else extendedColors.secondary300
    )
  }
}

@Composable
private fun TextWithSelectonColor(text: String, selected: Boolean) {
  val extendedColors = LocalExtendedColors.current
  Text(text = text, color = if (selected) extendedColors.primary50 else extendedColors.secondary900)
}

@Composable
inline private fun LongJumpButton(
        selectedPage: Int,
        jumpValue: Int,
        crossinline onChange: (Int) -> Unit
) {
  PaginationButton(selected = selectedPage == jumpValue, onClick = { onChange(jumpValue) }) {
    TextWithSelectonColor(text = jumpValue.toString(), selected = selectedPage == jumpValue)
  }
}

@Composable
fun Pagination(
        helpText: String,
        countItems: Int,
        perPage: Int,
        selectedPage: Int = 1,
        longJump: Int = 30,
        onChange: (Int) -> Unit
) {
  val countPage = (countItems / perPage).toInt()
  fun _onChange(it: Int) {
    if (it <= countPage && it > 0) onChange(it)
  }
  val nextLongJump =
          if ((selectedPage + longJump) > countPage) countPage else (selectedPage + longJump)
  val previusLongJump = if ((selectedPage - longJump) < 1) 1 else (selectedPage - longJump)
  val regress = COUNT_REPEAT / 2
  val initialPositionPage =
          if (selectedPage > regress)
                  selectedPage -
                          regress -
                          (if (selectedPage + regress > countPage)
                                  (selectedPage + regress) - countPage
                          else 0)
          else 1

  Box(modifier = Modifier.padding(top = 12.dp, bottom = 16.dp).height(40.dp).fillMaxWidth()) {
    Text(text = "$helpText: ${countItems}", fontSize = 16.sp, fontWeight = FontWeight.Light)
    Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      DirectionButton(
              value = selectedPage - 1,
              onChange = ::_onChange,
              enable = selectedPage > 1,
              painter = R.vectors.ic_arrow_left,
      )

      repeat(COUNT_REPEAT) {
        when (it) {
          START -> {
            LongJumpButton(
                    selectedPage = selectedPage,
                    jumpValue = previusLongJump,
                    onChange = ::_onChange,
            )
          }
          END -> {
            LongJumpButton(
                    selectedPage = selectedPage,
                    jumpValue = nextLongJump,
                    onChange = ::_onChange,
            )
          }
          else -> {
            val count = (initialPositionPage + it)
            PaginationButton(selected = selectedPage == count, onClick = { _onChange(count) }) {
              TextWithSelectonColor(text = count.toString(), selected = selectedPage == count)
            }
          }
        }
      }
      DirectionButton(
              value = selectedPage + 1,
              onChange = ::_onChange,
              enable = selectedPage < countPage,
              painter = R.vectors.ic_arrow_right,
      )
    }
  }
}
