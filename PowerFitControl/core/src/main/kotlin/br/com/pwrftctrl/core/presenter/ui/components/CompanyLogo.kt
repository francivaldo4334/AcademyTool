package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R
import com.composables.icons.lucide.Image
import com.composables.icons.lucide.Lucide

@Composable
fun CompanyLogo(modifier: Modifier = Modifier.size(72.dp)) {
    val extendedColors = LocalExtendedColors.current
    val fileImage = remember { R.loadImageFromFile("") }
    var imageWidth by remember { mutableStateOf(0) }
    var imageHeight by remember { mutableStateOf(0) }
    Box(
            modifier =
                    modifier.drawBehind {
                        imageWidth = size.width.toInt()
                        imageHeight = size.height.toInt()
                    }
    ) {
        if (fileImage != null)
                Image(
                        painter = fileImage,
                        contentDescription = "Imagem de perfil",
                        modifier =
                                Modifier.width(imageWidth.dp)
                                        .height(imageHeight.dp)
                                        .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                )
        else
                Icon(
                        imageVector = Lucide.Image,
                        contentDescription = null,
                        modifier =
                                Modifier.width(imageWidth.dp)
                                        .height(imageHeight.dp)
                                        .background(
                                                extendedColors.secondary100,
                                                shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(8.dp),
                        tint = extendedColors.secondary400
                )
    }
}
