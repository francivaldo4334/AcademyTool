package br.com.pwrftctrl.app.presenter.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R
import com.composables.icons.lucide.ChartNoAxesCombined
import com.composables.icons.lucide.Dumbbell
import com.composables.icons.lucide.HandCoins
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Settings
import com.composables.icons.lucide.Users

@Composable
fun SideBar(moduleSelected: ModuleSelection, setModuleSelection: (ModuleSelection) -> Unit) {
    val extendedColors = LocalExtendedColors.current
    Box(
            modifier =
                    Modifier.fillMaxHeight()
                            .width(56.dp)
                            .background(extendedColors.secondary900)
                            .padding(vertical = 8.dp)
    ) {
        Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                    iconPainter = rememberVectorPainter(Lucide.Users),
                    textHelp = R.strings.clients_manager,
                    moduleIndex = ModuleSelection.CLIENTS,
                    moduleSelected = moduleSelected,
                    onClick = { setModuleSelection(ModuleSelection.CLIENTS) }
            )
            Button(
                    iconPainter = rememberVectorPainter(Lucide.ChartNoAxesCombined),
                    textHelp = R.strings.show_metrics,
                    moduleIndex = ModuleSelection.METRICS,
                    moduleSelected = moduleSelected,
                    onClick = { setModuleSelection(ModuleSelection.METRICS) }
            )
            Button(
                    iconPainter = rememberVectorPainter(Lucide.Dumbbell),
                    textHelp = R.strings.equipments_control,
                    moduleIndex = ModuleSelection.DUMBBELLS,
                    moduleSelected = moduleSelected,
                    onClick = { setModuleSelection(ModuleSelection.DUMBBELLS) }
            )
            Button(
                    iconPainter = rememberVectorPainter(Lucide.HandCoins),
                    textHelp = R.strings.financial_control,
                    moduleIndex = ModuleSelection.HAND_MONEY,
                    moduleSelected = moduleSelected,
                    onClick = { setModuleSelection(ModuleSelection.HAND_MONEY) }
            )
        }
        Button(
                iconPainter = rememberVectorPainter(Lucide.Settings),
                textHelp = R.strings.settings,
                moduleIndex = ModuleSelection.SETTINGS,
                moduleSelected = moduleSelected,
                onClick = { setModuleSelection(ModuleSelection.SETTINGS) },
                modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
