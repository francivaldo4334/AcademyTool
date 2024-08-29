package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable 
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.Card
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Popup
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.clip
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

@Composable
fun SelectField(
    label: String,
    items: List<String> = emptyList(),
    selectedItem: String = "",
    onSelectedItem: (String) -> Unit = {},
) {
    var selectedItem by remember {
        mutableStateOf(selectedItem)
    }
    var contentHeight by remember {
        mutableStateOf(0)
    }
    var contentWidth by remember {
        mutableStateOf(0)
    }
    var minContentWidthSelection by remember {
        mutableStateOf(0)
    }
    var openPopup by remember {
        mutableStateOf(false)
    }
    val extendedColors = LocalExtendedColors.current
    val text = buildAnnotatedString{
        withStyle(style = SpanStyle(
            fontSize = 10.sp,
            color = extendedColors.primary800,
        )) { append(label) }
        if (selectedItem.isNotEmpty())
            withStyle(style = SpanStyle(
                fontSize = 10.sp,
                color = extendedColors.secondary900,
            )) {
                appendLine()
                append(selectedItem)
            }
    }
    Box(
        modifier = Modifier
            .border(2.dp, extendedColors.secondary200, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))                 
            .clickable{
                openPopup = true
            }
            .heightIn(min = 40.dp)
            .drawBehind {
                contentWidth = size.width.toInt()
                contentHeight = size.height.toInt()
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            Text(
                text = text,
                lineHeight = 12.sp
            )
            Icon(
                painter = R.vectors.ic_arrow_down,
                tint = extendedColors.secondary600,
                contentDescription = "Icone de dropdown",
                modifier = Modifier.size(16.dp)
            )
        }
        if (openPopup) {
            Popup(
                offset = IntOffset(0,contentHeight),
                onDismissRequest = {
                    openPopup = false
                }
            ) {
                Card(
                    backgroundColor = extendedColors.secondary50,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.widthIn(min = contentWidth.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(4.dp)
                            .drawBehind {
                                minContentWidthSelection = size.width.toInt()
                            }
                    ) {
                        if (items.isEmpty()) {
                            Text(
                                text = R.strings.has_no_items,
                                fontSize = 12.sp,
                                color = extendedColors.secondary400,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                        items.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable{
                                        selectedItem = item
                                        openPopup = false
                                        onSelectedItem(item)
                                    }
                                    .widthIn(min = minContentWidthSelection.dp)
                                    .padding(vertical = 4.dp, horizontal = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = item,
                                    fontSize = 14.sp,
                                )
                                if (item == selectedItem)
                                    Icon(
                                        painter = R.vectors.ic_checked,
                                        contentDescription = "icon de check",
                                        tint = extendedColors.secondary600,
                                        modifier = Modifier.size(16.dp)
                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}
