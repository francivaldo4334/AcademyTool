package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.pwrftctrl.core.utils.R
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun ProfileImage(fileName: String, modifier: Modifier = Modifier) {
  val extendedColors = LocalExtendedColors.current
  val fileImage = remember {
    R.loadImageFromFile(fileName)
  }
  var imageWidth by remember {
    mutableStateOf(0)
  }
  var imageHeight by remember {
    mutableStateOf(0)
  }
  Box(
    modifier = modifier
      .drawBehind{
        imageWidth = size.width.toInt()
        imageHeight = size.height.toInt()
      }
      .clip(RoundedCornerShape(8.dp))
  ) {
    if (fileImage != null)
      Image(
        painter = fileImage,
        contentDescription = "Imagem de perfil",
        modifier = Modifier.width(imageWidth.dp).height(imageHeight.dp),
        contentScale = ContentScale.Crop
      )
    else
      Box(
        modifier = Modifier
          .width(imageWidth.dp)
          .height(imageHeight.dp)
          .background(extendedColors.primary500),
      )
  }
}
