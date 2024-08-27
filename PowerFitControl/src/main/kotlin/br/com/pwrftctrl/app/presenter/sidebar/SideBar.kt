package br.com.pwrftctrl.app.presenter.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.pwrftctrl.app.presenter.enums.ModuleSelection
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.app.presenter.viewmodels.ModulesManagerViewModel
import br.com.pwrftctrl.core.presenter.viewmodels.MyViewModelFactory
import br.com.pwrftctrl.core.utils.Resources as R

@Composable
fun SideBar() {
        val extendedColors = LocalExtendedColors.current
        val modulesManagerViewModel = MyViewModelFactory.create(ModulesManagerViewModel::class.java)
        val moduleSelected = modulesManagerViewModel.moduleSelected.collectAsState()
        Box(
                modifier =
                        Modifier.fillMaxHeight()
                                .width(56.dp)
                                .background(extendedColors.secondary900)
                                .padding(8.dp),
        ) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                        Button(
                                iconPainter = R.vectors.ic_clients,
                                textHelp = R.strings.clients_manager,
                                moduleIndex = ModuleSelection.CLIENTS,
                                moduleSelected = moduleSelected.value
                        )
                        Button(
                                iconPainter = R.vectors.ic_status_up,
                                textHelp = R.strings.show_metrics,
                                moduleIndex = ModuleSelection.METRICS,
                                moduleSelected = moduleSelected.value
                        )
                        Button(
                                iconPainter = R.vectors.ic_dumbbells,
                                textHelp = R.strings.equipments_control,
                                moduleIndex = ModuleSelection.DUMBBLELLS,
                                moduleSelected = moduleSelected.value
                        )
                        Button(
                                iconPainter = R.vectors.ic_hand_money,
                                textHelp = R.strings.financial_control,
                                moduleIndex = ModuleSelection.HAND_MONEY,
                                moduleSelected = moduleSelected.value
                        )
                }
                Button(
                        iconPainter = R.vectors.ic_settings,
                        textHelp = R.strings.settings,
                        moduleIndex = ModuleSelection.SETTINGS,
                        moduleSelected = moduleSelected.value,
                        modifier = Modifier.align(Alignment.BottomCenter)
                )
        }
}
