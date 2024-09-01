package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R

data class HeaderItem(
    val title: String,
    val minWidth: Dp? = null,
    val maxWidth: Dp? = null,
    val onSortAction: (() -> Unit)? = null
)


@Composable
private fun RowScope.HeaderItemLayout(
    props: HeaderItem
) {
    var sorted by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(props.onSortAction != null) {
                sorted = !sorted
                props.onSortAction?.invoke()
            }
            .then(
                if (props.maxWidth == null)
                    Modifier.weight(1f)
                else Modifier
            )
            .then(
                if (props.minWidth != null)
                    Modifier.widthIn(min = props.minWidth)
                else Modifier
            )
            .then(
                if (props.maxWidth != null)
                    Modifier.widthIn(max = props.maxWidth)
                else Modifier
            )
            .heightIn(min = 32.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = props.title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        if (props.onSortAction != null) {
            Icon(
                painter = if (sorted)
                    R.vectors.ic_arrow_up_bold
                else
                    R.vectors.ic_arrow_down_bold,
                contentDescription = "Ordenação de lista",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun Header(items: List<HeaderItem>) {
    val extendedColors = LocalExtendedColors.current
    Row(
        modifier =
        Modifier.fillMaxWidth()
            .heightIn(min = 32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(extendedColors.secondary100),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { HeaderItemLayout(it) }
    }
}

@Composable
fun ColumnScope.Table(
    headerItems: List<HeaderItem>
) {
    val extendedColors = LocalExtendedColors.current
    Column(
        modifier =
        Modifier.border(2.dp, extendedColors.secondary200, RoundedCornerShape(12.dp))
            .weight(1f)
            .fillMaxWidth()
            .padding(12.dp),
    ) { Header(headerItems) }
}
