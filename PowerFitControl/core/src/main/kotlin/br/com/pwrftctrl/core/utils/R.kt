package br.com.pwrftctrl.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import java.util.*


object R {
    private val bundle: ResourceBundle
    init {
        val locale = Locale.getDefault()
        bundle = ResourceBundle.getBundle("values/strings", locale)
    }
    fun getString(key: String): String {
        return bundle.getString(key)
    }
    @Composable
    fun getVector(key: String): Painter {
        return painterResource("drawable/$key")
    }
    val strings = ResourceStrings()
    val vectors = ResourceVectors()
}

