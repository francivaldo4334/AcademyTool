package br.com.pwrftctrl.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import java.util.*
import java.nio.file.Paths
import java.io.File


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

    private fun getFileResouces(fileName: String): String {
        val os = System.getProperty("os.name").lowercase()
        val appName = R.strings.app_name
        val path = when {
            os.contains("win") ->
                Paths.get(System.getenv("APPDATA"), appName, fileName).toString()

            os.contains("nix") || os.contains("nux") || os.contains("mac") ->
                Paths.get(System.getenv("HOME"), ".$appName", fileName).toString()

            else -> fileName
        }
        val directory = File(path).parentFile
        if (directory != null && !directory.exists()) { directory.mkdirs() }
        return path
    }

    fun loadImageFromFile(fileName: String): Painter? {
        return try {
            val filePath = getFileResouces("/img/$fileName")
            val imageBitmap = loadImageBitmap(File(filePath).inputStream())
            BitmapPainter(image = imageBitmap)
        } catch(e: Exception) {
            null
        }
    }

    val strings = Strings()
}

