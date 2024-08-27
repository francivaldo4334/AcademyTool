package br.com.pwrftctrl.core.utils

import java.io.File
import java.nio.file.Paths

data class ResourceStrings(
        val clients_manager: String = R.getString("clients_manager"),
        val show_metrics: String = R.getString("show_metrics"),
        val equipments_control: String = R.getString("equipments_control"),
        val financial_control: String = R.getString("financial_control"),
        val app_name: String = R.getString("app_name"),
        val clients_option_students: String = R.getString("clients_option_students"),
        val clients_option_classes: String = R.getString("clients_option_classes"),
        val clients_option_birthdays: String = R.getString("clients_option_birthdays"),
        val settings: String = R.getString("settings"),
        val search: String = R.getString("search"),
) {
    fun getDatabasePath(): String {
        val os = System.getProperty("os.name").lowercase()
        val appName = R.strings.app_name
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
}
