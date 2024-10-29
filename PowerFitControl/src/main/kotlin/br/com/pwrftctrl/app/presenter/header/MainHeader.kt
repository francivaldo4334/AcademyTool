package br.com.pwrftctrl.app.presenter.header

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import br.com.pwrftctrl.app.presenter.header.viewmodels.ProfileManagerViewModel
import br.com.pwrftctrl.core.presenter.ui.components.IconButton
import br.com.pwrftctrl.core.presenter.viewmodels.MyViewModelFactory
import br.com.pwrftctrl.core.utils.R
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.LogOut

@Composable
fun MainHeader() {
    val profileManager = MyViewModelFactory.create(ProfileManagerViewModel::class.java)
    val profileLogged = profileManager.profileLogged.collectAsState()
    val profileName = profileManager.profileName.collectAsState()
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp).padding(horizontal = 16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            // LogoImage
            Logo()
            // LogoPowerFitControl
            Logo()
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // User name and profile
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    profileName.value,
                    fontSize = 20.sp,
                )
                Text(
                    profileManager.getProfileName(profileLogged.value),
                    fontSize = 12.sp,
                )
            }
            // Profil photo
            ProfilePhoto()
            // Buton Logout
            IconButton(
                painter = rememberVectorPainter(Lucide.LogOut),
                contentDescription = "Botão de logout",
                onClick = {
                    // TODO: Logout action
                }
            )
        }
    }
}
