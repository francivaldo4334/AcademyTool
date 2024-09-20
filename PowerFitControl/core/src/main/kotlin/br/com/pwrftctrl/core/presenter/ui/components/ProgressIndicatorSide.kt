package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

@Composable
fun ProgressIndicatorSide(
    tasks: List<String>,
    indexTask: Int = 1,
    currentTaskComplected: Boolean = true,
) {
    val extendedColor = LocalExtendedColors.current
    Column(
        modifier = Modifier
            .widthIn(min=200.dp)
            .heightIn(min=200.dp)
            .background(extendedColor.secondary50)
            .padding(16.dp)
    ) {
        CompanyLogo()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "#Teste",
            color = extendedColor.primary900,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(40.dp))
        tasks.forEachIndexed{ id, it ->
            val showSelection = (id + 1) == indexTask
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            if (currentTaskComplected && showSelection) {
                                extendedColor.primary500                  
                            }
                            else {
                                extendedColor.secondary300
                            }
                        )
                        .then(
                            if (showSelection) {
                                Modifier.border(border = BorderStroke(2.dp, extendedColor.primary500), shape = CircleShape)
                            }
                            else {
                                Modifier
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (showSelection && currentTaskComplected) {
                        Icon(
                            painter = R.vectors.ic_checked,
                            contentDescription = null,
                            tint = extendedColor.secondary50,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    else if (showSelection){
                        Text(
                            text = (id +1).toString(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Text(
                    text = it,
                    color = extendedColor.secondary900,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
        }
    }
}
