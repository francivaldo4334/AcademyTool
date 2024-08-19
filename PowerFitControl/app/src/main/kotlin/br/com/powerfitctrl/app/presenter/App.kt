package br.com.powerfitctrl.app

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.powerfitctrl.app.utils.StringResources
import br.com.powerfitctrl.app.utils.getDatabasePath
// import org.jetbrains.exposed.dao.id.IntIdTable
// import org.jetbrains.exposed.sql.Database
// import org.jetbrains.exposed.sql.SchemaUtils.create
// import org.jetbrains.exposed.sql.transactions.transaction

// object User : IntIdTable() {
//     val name = varchar(name = "name", length = 255)
// }

@Composable
fun App() {
    // LaunchedEffect(Unit) {
    //     val databaseUrl = getDatabasePath()
    //     Database.connect("jdbc:sqlite:$databaseUrl", "org.sqlite.JDBC")
    //     transaction { create(User) }
    // }
    Text("FRAN")
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = StringResources.getString("app_name")) {
        App()
    }
}
