package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.Alignment
import androidx.compose.material.Icon
import androidx.compose.material.Text

@Composable
fun BaseStatusCounter(backgroundColor: Color, tint: Color, painter: Painter, count: String, textTip: String) {
  PopoverTip(
    alignment = Alignment.BottomStart,
    offset = IntOffset(4, 4),
    contentComponent = {
      Row(
        modifier = Modifier.height(32.dp).background(backgroundColor, shape = RoundedCornerShape(12.dp)).padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
      ) {
        Icon(
          painter = painter,
          contentDescription = "",
          tint = tint
        )
        if (count.isNotEmpty())
          Text(count, fontSize=10.sp, color = tint)
      } 
    }
  ) {
    Text(textTip)
  }
}
