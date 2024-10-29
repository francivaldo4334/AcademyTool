package br.com.pwrftctrl.core.presenter.ui.components

import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import br.com.pwrftctrl.core.presenter.ui.theme.LocalExtendedColors
import br.com.pwrftctrl.core.utils.R
import androidx.compose.ui.graphics.Color
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Undo

@Composable
fun BackButton(
        enabled: Boolean = true, 
        onClick: () -> Unit,
) {
        val extendedColors = LocalExtendedColors.current
        Button(
                enabled = enabled,
                onClick = onClick,
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 8.dp),
                modifier = Modifier
                        .height(40.dp),
                colors =
                        ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = extendedColors.secondary600
                        ),
                elevation = null,
                shape = RoundedCornerShape(8.dp)
        ) { 
                Text(R.strings.go_to_back)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                        imageVector = Lucide.Undo,
                        contentDescription = "Voltar"
                )
        }
}
