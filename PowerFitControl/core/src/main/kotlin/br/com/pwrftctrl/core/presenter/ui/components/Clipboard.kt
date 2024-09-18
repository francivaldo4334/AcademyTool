package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

@Composable
fun Clipboard(text: String) {
  val extendedColors = LocalExtendedColors.current
  Row(
    modifier = Modifier
      .clip(RoundedCornerShape(16.dp))
      .clickable{

      }
      .background(extendedColors.secondary50)
      .padding(vertical = 8.dp).padding(start = 12.dp, end = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
  ) {
    Text(
      text = text
    )
    Icon(
      painter = R.vectors.ic_clipboard,
      contentDescription = "Copiar texto",
      modifier = Modifier.size(16.dp)
    )
  }
}
