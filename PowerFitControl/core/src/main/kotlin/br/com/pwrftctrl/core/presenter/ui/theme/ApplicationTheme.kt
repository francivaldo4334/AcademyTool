package br.com.pwrftctrl.core.presenter.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import br.com.pwrftctrl.core.presenter.ui.*

data class ExtendedColors(
    val white: Color,
    val red100: Color,
    val red900: Color,
    val gray100: Color,
    val gray900: Color,
    val blue100: Color,
    val blue900: Color,
    val primary50: Color,
    val yellow100: Color,
    val yellow900: Color,
    val primary100: Color,
    val primary500: Color,
    val primary800: Color,
    val primary900: Color,
    val secondary50: Color,
    val secondary100: Color,
    val secondary200: Color,
    val secondary300: Color,
    val secondary400: Color,
    val secondary500: Color,
    val secondary600: Color,
    val secondary800: Color,
    val secondary900: Color,
)

// Definição de cores
private val colorScheme =
    lightColors(primary = primary500, secondary = secondary500, onBackground = secondary900)

fun extendedColorScheme() =
    ExtendedColors(
        white = white,
        red100 = red100,
        red900 = red900,
        gray100 = gray100,
        gray900 = gray900,
        blue100 = blue100,
        blue900 = blue900,
        yellow100 = yellow100,
        yellow900 = yellow900,
        primary50 = primary50,
        primary100 = primary100,
        primary500 = primary500,
        primary800 = primary800,
        primary900 = primary900,
        secondary50 = secondary50,
        secondary100 = secondary100,
        secondary200 = secondary200,
        secondary300 = secondary300,
        secondary400 = secondary400,
        secondary500 = secondary500,
        secondary600 = secondary600,
        secondary800 = secondary800,
        secondary900 = secondary900,
    )

val LocalExtendedColors = staticCompositionLocalOf { extendedColorScheme() }

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val extendedColors = remember { extendedColorScheme() }
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colors = colorScheme,
            // typography = MaterialTheme.typography,
            typography = customTypography,
            content = content,
        )
    }
}
