package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSave
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors

data class FormItemSelection(val content: @Composable () -> Unit, val onClick: () -> Unit)

@Composable
fun FormSelection(
    options: List<FormItemSelection>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val strokeWidth = 1.dp
    val cornerRadius = 8.dp
    var widthItemSelected by remember {
        mutableStateOf(0f)
    }
    var positionX by remember {
        mutableStateOf(0f)
    }
    val extendedColors = LocalExtendedColors.current
    Column(
        modifier = modifier.wrapContentWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = cornerRadius),
        ) {
            for (it in options) {
                var itemPositionX by remember {
                    mutableStateOf(0f)
                }
                var itemWidth by remember {
                    mutableStateOf(0f)
                }
                Box(
                    modifier = Modifier
                        .onGloballyPositioned {
                            itemPositionX = it.positionInParent().x
                            itemWidth = it.size.width.toFloat()
                            if (positionX == 0f && widthItemSelected == 0f) {
                                positionX = itemPositionX
                                widthItemSelected = itemWidth
                            }
                        }
                        .drawBehind {
                            val path = Path().apply {
                                moveTo(0f, size.height)
                                lineTo(0f, cornerRadius.toPx())
                                quadraticBezierTo(
                                    0f, 0f,
                                    cornerRadius.toPx(), 0f
                                )
                                lineTo(size.width - cornerRadius.toPx(), 0f)
                                quadraticBezierTo(
                                    size.width, 0f,
                                    size.width, cornerRadius.toPx()
                                )
                                lineTo(size.width, size.height)
                            }
                            drawIntoCanvas { canvas ->
                                canvas.withSave {
                                    drawPath(
                                        path = path,
                                        color = extendedColors.secondary200,
                                        style = Stroke(
                                            width = strokeWidth.toPx(),
                                            cap = StrokeCap.Round,
                                            join = StrokeJoin.Round
                                        )
                                    )
                                }
                            }
                        }
                        .widthIn(min = 32.dp)
                        .heightIn(min = 32.dp)
                        .clip(RoundedCornerShape(topEnd = cornerRadius, topStart = cornerRadius))
                        .clickable {
                            //OnClick
                            positionX = itemPositionX
                            widthItemSelected = itemWidth
                            it.onClick()
                        }
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    //Composable content
                    it.content()
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path().apply {
                        moveTo(positionX + cornerRadius.toPx(), 0f)
                        lineTo(cornerRadius.toPx(), 0f)
                        quadraticBezierTo(
                            0f, 0f,
                            0f, cornerRadius.toPx()
                        )
                        lineTo(0f, size.height - cornerRadius.toPx())
                        quadraticBezierTo(
                            0f, size.height,
                            cornerRadius.toPx(), size.height
                        )
                        lineTo(size.width - cornerRadius.toPx(), size.height)
                        quadraticBezierTo(
                            size.width, size.height,
                            size.width, size.height - cornerRadius.toPx()
                        )
                        lineTo(size.width, cornerRadius.toPx())
                        quadraticBezierTo(
                            size.width, 0f,
                            size.width - cornerRadius.toPx(), 0f
                        )
                        lineTo(positionX + widthItemSelected + cornerRadius.toPx(), 0f)
                    }
                    drawIntoCanvas { canvas ->
                        canvas.withSave {
                            drawPath(
                                path = path,
                                color = extendedColors.secondary200,
                                style = Stroke(
                                    width = strokeWidth.toPx(),
                                    cap = StrokeCap.Round,
                                    join = StrokeJoin.Round
                                )
                            )
                        }
                    }
                }
                .widthIn(min = 32.dp)
                .heightIn(min = 32.dp)
        ) {
            content()
        }
    }
}
