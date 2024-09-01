package br.com.pwrftctrl.core.presenter.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

private val customFontFamily = FontFamily(
    Font("fonts/Poppins/Poppins-Regular.ttf"),
    Font("fonts/Poppins/Poppins-Bold.ttf", FontWeight.Bold),
    Font("fonts/Poppins/Poppins-Medium.ttf", FontWeight.Medium),
    Font("fonts/Poppins/Poppins-Thin.ttf", FontWeight.Thin),
    Font("fonts/Poppins/Poppins-Black.ttf", FontWeight.Black),
    Font("fonts/Poppins/Poppins-Light.ttf", FontWeight.Light),
    Font("fonts/Poppins/Poppins-Regular.ttf", FontWeight.Normal),
    Font("fonts/Poppins/Poppins-ExtraLight.ttf", FontWeight.ExtraLight),
    Font("fonts/Poppins/Poppins-ExtraBold.ttf", FontWeight.ExtraBold),
    Font("fonts/Poppins/Poppins-SemiBold.ttf", FontWeight.SemiBold),

    )

val customTypography = Typography(
    body1 = TextStyle(
        fontFamily = customFontFamily,
    )
)
