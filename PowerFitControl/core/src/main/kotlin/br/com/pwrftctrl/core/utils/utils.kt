package br.com.pwrftctrl.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
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

class ResourceVectors() {
  val ic_clients: Painter
    @Composable
    get() {
      return Resources.getVector("ic_clients.svg")
    }
  val ic_dumbbells: Painter
    @Composable
    get() {
      return Resources.getVector("ic_dumbbells.svg")
    }
  val ic_hand_money: Painter
    @Composable
    get() {
      return Resources.getVector("ic_hand_money.svg")
    }
  val ic_status_up: Painter
    @Composable
    get() {
      return Resources.getVector("ic_status_up.svg")
    }
}

object Resources {
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
