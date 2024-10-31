package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import com.composables.icons.lucide.ChevronDown
import com.composables.icons.lucide.ChevronUp
import com.composables.icons.lucide.Lucide

data class HeaderItem(
        val title: String,
        val minWidth: Dp? = null,
        val maxWidth: Dp? = null,
        val onSortAction: (() -> Unit)? = null
)

@Composable
inline private fun RowScope.HeaderItemLayout(
        props: HeaderItem,
        crossinline onWidthItem: (Dp) -> Unit
) {
    var sorted by remember { mutableStateOf(false) }
    Row(
            modifier =
                    Modifier.clip(RoundedCornerShape(8.dp))
                            .clickable(props.onSortAction != null) {
                                sorted = !sorted
                                props.onSortAction?.invoke()
                            }
                            .then(if (props.maxWidth == null) Modifier.weight(1f) else Modifier)
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
                            .drawBehind { onWidthItem(size.width.toInt().dp) }
                            .heightIn(min = 32.dp)
                            .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = props.title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        if (props.onSortAction != null) {
            Icon(
                    imageVector = if (sorted) Lucide.ChevronUp else Lucide.ChevronDown,
                    contentDescription = "Ordenação de lista",
                    modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun Header(items: List<HeaderItem>, onChangeItemSize: (index: Int, width: Dp) -> Unit) {
    val extendedColors = LocalExtendedColors.current
    Row(
            modifier =
                    Modifier.padding(bottom = 4.dp)
                            .fillMaxWidth()
                            .heightIn(min = 32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(extendedColors.secondary100),
            verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, it ->
            HeaderItemLayout(props = it, onWidthItem = { width -> onChangeItemSize(index, width) })
        }
    }
}

class TableRows(val sizeRow: Int) {
    data class Cell(
            val key: Int,
            val contents: Array<@Composable () -> Unit>,
            val onClick: () -> Unit
    )
    val rows: MutableList<Cell> = mutableListOf<Cell>()
    fun row(key: Int, vararg contents: @Composable () -> Unit, onClick: () -> Unit) {
        if (contents.size != sizeRow)
                throw ArrayIndexOutOfBoundsException(
                        "O numero de celulas deve ser memo setado para o header"
                )
        val cellsContents = contents as Array<@Composable () -> Unit>
        rows.add(Cell(key, cellsContents, onClick))
    }
}

@Composable
private fun RowScope.CellLayout(width: Dp, content: @Composable () -> Unit) {
    Box(modifier = Modifier.heightIn(min = 32.dp), contentAlignment = Alignment.CenterStart) {
        Box(
                modifier = Modifier.width(width),
        ) { content() }
    }
}

@Composable
fun RowCell(cell: TableRows.Cell, listItemSizes: List<Dp>) {
    Row(
            modifier = Modifier.clip(RoundedCornerShape(12.dp)).clickable { cell.onClick() },
            verticalAlignment = Alignment.CenterVertically
    ) { listItemSizes.forEachIndexed { index, it -> CellLayout(it, cell.contents[index]) } }
}

@Composable
fun ColumnScope.Table(
        headerItems: List<HeaderItem>,
        rows: TableRows.() -> Unit,
) {
    val extendedColors = LocalExtendedColors.current
    val tableRows = TableRows(headerItems.size).apply { rows() }
    var listWidth = remember { mutableStateListOf(*headerItems.map { 0.dp }.toTypedArray()) }
    Column(
            modifier =
                    Modifier.border(2.dp, extendedColors.secondary200, RoundedCornerShape(12.dp))
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(12.dp),
    ) {
        Header(items = headerItems, onChangeItemSize = { id, it -> listWidth[id] = it })
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = tableRows.rows, key = { it.key }) { cell -> RowCell(cell, listWidth) }
        }
    }
}
