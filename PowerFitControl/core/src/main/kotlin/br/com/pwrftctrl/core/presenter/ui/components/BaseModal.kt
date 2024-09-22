package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import br.com.pwrftctrl.core.presenter.ui.dimensions.LocalDimensionsSizeScreen

@Composable
fun BaseModal(
        onDismissRequest: () -> Unit,
        content: @Composable () -> Unit,
) {
        Dialog(
                onDismissRequest = onDismissRequest,
                properties =
                        DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
        ) {
                Box(
                        modifier =
                                Modifier.background(
                                                color = MaterialTheme.colors.background,
                                                shape = RoundedCornerShape(24.dp)
                                        )
                                        .widthIn(
                                                min =
                                                        LocalDimensionsSizeScreen
                                                                .defaultModalMinWidth
                                                                .dp,
                                        )
                                        .heightIn(
                                                min =
                                                        LocalDimensionsSizeScreen
                                                                .defaultModalMinHeight
                                                                .dp,
                                        )
                                        .clip(RoundedCornerShape(24.dp)),
                ) { content() }
        }
}
