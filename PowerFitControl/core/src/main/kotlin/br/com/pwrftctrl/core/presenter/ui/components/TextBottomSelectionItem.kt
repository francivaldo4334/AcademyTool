package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

@Composable
fun TextBottomSelectionItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val lineLengh = animateFloatAsState(targetValue = if (selected) 1f else 0f)

    val extendedColors = LocalExtendedColors.current
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        modifier =
        Modifier.drawBehind {
            if (selected) {
                val strokeWidth = 4.dp.toPx()
                val centerHorizontal = size.width / 2
                drawLine(
                    color = extendedColors.primary500,
                    start =
                    Offset(
                        centerHorizontal -
                                (lineLengh.value *
                                        centerHorizontal),
                        size.height
                    ),
                    end =
                    Offset(
                        centerHorizontal +
                                (centerHorizontal *
                                        lineLengh
                                            .value),
                        size.height
                    ),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .widthIn(min = 72.dp)
            .padding(vertical = 12.dp, horizontal = 16.dp)
    )
}
