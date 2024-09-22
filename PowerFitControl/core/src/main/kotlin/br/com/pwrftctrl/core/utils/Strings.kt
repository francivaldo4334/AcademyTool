package br.com.pwrftctrl.core.utils

import java.io.File
import java.nio.file.Paths

data class Strings(
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
        val has_no_items: String = R.getString("has_no_items"),
        val students_in_debt: String = R.getString("students_in_debt"),
        val students_checkeds: String = R.getString("students_checkeds"),
        val birthdays_of_month: String = R.getString("birthdays_of_month"),
        val missing_students: String = R.getString("missing_students"),
        val avatar: String = R.getString("avatar"),
        val name: String = R.getString("name"),
        val register: String = R.getString("register"),
        val age: String = R.getString("age"),
        val email: String = R.getString("email"),
        val status: String = R.getString("status"),
        val phone_or_whatsapp: String = R.getString("phone_or_whatsapp"),
        val items_per_page: String = R.getString("items_per_page"),
        val clients: String = R.getString("clients"),
        val total_number_of_students: String = R.getString("total_number_of_students"),
        val birthday: String = R.getString("birthday"),
        val in_debt: String = R.getString("in_debt"),
        val checked: String = R.getString("checked"),
        val missing: String = R.getString("missing"),
        val cancell: String = R.getString("cancell"),
        val go_to_back: String = R.getString("go_to_back"),
        val next: String = R.getString("next")
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
