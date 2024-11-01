package br.com.pwrftctrl.students.data.dao

import br.com.pwrftctrl.core.data.dao.IBaseDao
import br.com.pwrftctrl.students.data.models.Registration
import br.com.pwrftctrl.students.data.models.Registrations
import br.com.pwrftctrl.students.data.models.map
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class RegistrationDao : IBaseDao<Registration> {

    override fun getAll(): Query = transaction { Registrations.select(Registrations.columns) }

    override fun getById(pk: Int): Query = transaction {
        Registrations.select(Registrations.columns).where { Registrations.id eq pk }.limit(1)
    }

    override fun insert(model: Registration): Int = transaction {
        (Registrations.insert { it.map(model) } get Registrations.id).value
    }

    override fun update(model: Registration): Int = transaction {
        Registrations.update({ Registrations.id eq model.id }) { it.map(model) }
    }

    override fun delete(pk: Int): Int = transaction { Registrations.deleteWhere { this.id eq pk } }
}
