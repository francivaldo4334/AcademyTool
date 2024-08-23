package br.com.pwrftctrl.core.utils

import java.io.File
import java.nio.file.Paths
import java.util.Locale
import java.util.ResourceBundle

data class ResourceStrings(
        val controle_de_clientes: String = Resources.getString("controle_de_clientes"),
        val visualizar_metricas: String = Resources.getString("visualizar_metricas"),
        val controle_de_equipamentos: String = Resources.getString("controle_de_equipamentos"),
        val controle_financeiro: String = Resources.getString("controle_financeiro"),
        val app_name: String = Resources.getString("app_name"),
)

object Resources {
  private val bundle: ResourceBundle
  init {
    val locale = Locale.getDefault()
    bundle = ResourceBundle.getBundle("values/strings", locale)
  }
  fun getString(key: String): String {
    return bundle.getString(key)
  }
  val strings = ResourceStrings()
}

fun getDatabasePath(): String {
  val os = System.getProperty("os.name").lowercase()
  val appName = Resources.strings.app_name
  val databaseName = "database.db"

  val path =
          when {
            os.contains("win") ->
                    Paths.get(System.getenv("APPDATA"), appName, databaseName).toString()
            os.contains("nix") || os.contains("nux") || os.contains("mac") ->
                    Paths.get(System.getenv("HOME"), ".$appName", databaseName).toString()
            else -> databaseName
          }
  val directory = File(path).parentFile
  if (directory != null && !directory.exists()) {
    directory.mkdirs()
  }
  return path
}
