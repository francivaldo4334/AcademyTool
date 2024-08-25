package br.com.pwrftctrl.app.presenter.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.pwrftctrl.app.presenter.ui.components.IconButton
import br.com.pwrftctrl.app.presenter.viewmodels.MyViewModelFactory
import br.com.pwrftctrl.app.presenter.viewmodels.ProfileManagerViewModel
import br.com.pwrftctrl.core.utils.Resources as R

@Composable
fun MainHeader() {
  val profileManager = MyViewModelFactory.create(ProfileManagerViewModel::class.java)
  val profileLogged = profileManager.profileLogged.collectAsState()
  val profileName = profileManager.profileName.collectAsState()
  Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth().padding(top = 32.dp).padding(horizontal = 32.dp)
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
                profileManager.profileName.value,
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
              painter = R.vectors.ic_logout,
              contentDescription = "Botão de logout",
              onClick = {
                // TODO: Logout action
              }
      )
    }
  }
}
