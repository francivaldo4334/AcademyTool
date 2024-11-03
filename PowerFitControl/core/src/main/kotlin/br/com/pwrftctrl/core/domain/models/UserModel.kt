package br.com.pwrftctrl.core.domain.models

import br.com.pwrftctrl.core.data.models.User
import br.com.pwrftctrl.core.domain.utils.toDateDays
import br.com.pwrftctrl.core.domain.utils.toDateTimeMinutes
import br.com.pwrftctrl.core.domain.utils.toHash
import java.time.LocalDate

data class UserModel(
        val id: Int,
        val cpf: String,
        val active: Boolean = true,
        val firstName: String,
        val lastName: String,
        val email: String,
        val registrationDate: LocalDate? = null,
        val dateOfBirth: LocalDate,
        val gender: String,
        val phone1: String,
        val phone2: String,
        val whatsapp: String,
        val photo: String,
        val neighborhood: String,
        val zipCode: String,
        val city: String,
        val lastLogin: LocalDate? = null,
        val password: String? = null,
)

fun UserModel.toDaoModel(): User =
        User(
                id = this.id,
                cpf = this.cpf,
                active = this.active,
                firstName = this.firstName,
                lastName = this.lastName,
                email = this.email,
                registrationDate =
                        if (this.registrationDate != null) this.registrationDate.toDateTimeMinutes()
                        else LocalDate.now().toDateTimeMinutes(),
                dateOfBirth = this.dateOfBirth.toDateDays(),
                gender = this.gender,
                phone1 = this.phone1,
                phone2 = this.phone2,
                whatsapp = this.whatsapp,
                photo = this.photo,
                addressString = "",
                neighborhood = this.neighborhood,
                zipCode = this.zipCode,
                city = this.city,
                lastLogin = this.lastLogin?.toDateTimeMinutes(),
                hash = password?.toHash(),
        )
