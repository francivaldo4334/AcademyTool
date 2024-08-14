package br.com.academytool.utils
import java.nio.file.Paths
import java.util.jar.Manifest
import java.util.ResourceBundle
import java.util.Locale
import java.io.File

fun getDatabasePath() : String {
  val os = System.getProperty("os.name").lowercase()
  val appName = StringResources.getString("app_name")
  val databaseName = "database.db"
   
  val path = when{
    os.contains("win") -> Paths.get(System.getenv("APPDATA"), appName, databaseName).toString()
    os.contains("nix") || os.contains("nux") || os.contains("mac") -> Paths.get(System.getenv("HOME"), ".$appName", databaseName).toString()
    else -> databaseName
  }
  val directory = File(path).parentFile
  if (directory != null && !directory.exists()) {
    directory.mkdirs()
  }
  return path
}

object StringResources {
  private val bundle: ResourceBundle
  init {
    val locale = Locale.getDefault()
    bundle = ResourceBundle.getBundle("values/strings", locale)
  }
  fun getString(key: String) : String {
    return bundle.getString(key)
  }
}
