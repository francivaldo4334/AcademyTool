package br.com.pwrftctrl.core.data

import br.com.pwrftctrl.core.utils.R
import org.jetbrains.exposed.sql.Database as ExposedDb

object MyDatabase {
  private val databaseUrl = R.strings.getDatabasePath()
  val connection: ExposedDb by lazy {
    ExposedDb.connect("jdbc:sqlite:${databaseUrl}", "org.sqlite.JDBC")
  }
}
