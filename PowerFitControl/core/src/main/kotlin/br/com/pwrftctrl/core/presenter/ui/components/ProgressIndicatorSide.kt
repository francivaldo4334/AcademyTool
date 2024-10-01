package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.presenter.utils.Form
import br.com.pwrftctrl.core.utils.R

@Composable
fun ProgressIndicatorSide(
    title: String,
    form: Form,
    onCancell: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (String) -> Unit,
) {
    val tasks = form.getFormNames()
    var indexTask by remember { mutableStateOf(0) }
    var currentTaskComplected by remember { mutableStateOf(false) }
    val extendedColor = LocalExtendedColors.current
    var maxHeight by remember { mutableStateOf(0.dp) }
    Row(
        modifier = Modifier.drawBehind { maxHeight = size.height.toDp() }
    ) {
        Column(
            modifier = Modifier.widthIn(min = 200.dp)
                .heightIn(min = 200.dp)
                .background(extendedColor.secondary50)
                .padding(16.dp)
                .then(modifier)
        ) {
            CompanyLogo()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "#$title",
                color = extendedColor.primary900,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(40.dp))
            tasks.forEachIndexed { id, it ->
                val isLessIndexSelected = id < indexTask
                val isSelected = id == indexTask
                val animatedColorBackground by animateColorAsState(
                    targetValue =
                    if (isLessIndexSelected ||
                        isSelected && currentTaskComplected
                    ) {
                        extendedColor
                            .primary500
                    } else if (isSelected) {
                        extendedColor
                            .green100
                    } else {
                        extendedColor
                            .secondary200
                    },
                    animationSpec = tween()
                )
                if (id != 0) {
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(48.dp)
                            .padding(
                                horizontal = 10.dp,
                                vertical = 4.dp
                            )
                            .background(
                                color = animatedColorBackground,
                                shape = RoundedCornerShape(2.dp)
                            )
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Column(
                        modifier =
                        Modifier.size(24.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(animatedColorBackground),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val showIcCheck = isLessIndexSelected || (isSelected && currentTaskComplected)
                        val showIcAlert = !showIcCheck && isSelected
                        AnimatedVisibility(
                            visible = showIcCheck,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),
                        ) {
                            Icon(
                                painter = R.vectors.ic_checked,
                                contentDescription = null,
                                tint = extendedColor.secondary50,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        AnimatedVisibility(
                            visible = showIcAlert,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),
                        ) {
                            Icon(
                                painter = R.vectors.ic_alert,
                                contentDescription = null,
                                tint = extendedColor.primary900,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        AnimatedVisibility(
                            visible = !showIcAlert && !showIcCheck,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),

                            ) {
                            Text(
                                text = (id + 1).toString(),
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
        Column(
            modifier = Modifier.height(maxHeight),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                content(form.getForm(tasks[indexTask]).toString())
            }
            Row(
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 16.dp).fillMaxWidth()
            ) {
                val endForm = indexTask >= tasks.size - 1
                if (indexTask > 0)
                    BackButton { indexTask-- }
                Spacer(modifier = Modifier.weight(1f))
                CancellButton { onCancell() }
                Spacer(modifier = Modifier.width(16.dp))
                TextButton(
                    enabled = (!endForm || currentTaskComplected),
                    onClick = {
                        if (endForm && currentTaskComplected) {
                            if (form.getForm(tasks[indexTask].toString()).validation()) {
                                form.onSubmit()
                            }
                        } else if (!endForm) {
                            currentTaskComplected = form.getForm(tasks[indexTask]).validation()
                            if (currentTaskComplected) {
                                indexTask++
                            }
                        }
                    }
                ) {
                    if (endForm) {
                        Text("Concluir")
                    } else {
                        Text(R.strings.next)
                    }
                }
            }
        }
    }

}
