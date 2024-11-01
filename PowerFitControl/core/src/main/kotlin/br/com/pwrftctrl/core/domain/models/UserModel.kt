package br.com.pwrftctrl.core.domain.models

import br.com.pwrftctrl.core.data.models.User
import br.com.pwrftctrl.core.domain.utils.toDateTimeDays
import br.com.pwrftctrl.core.domain.utils.toDateTimeMinutes
import br.com.pwrftctrl.core.domain.utils.toHash
import java.time.LocalDate

data class UserModel(
        val id: Int,
        val cpf: String,
        val active: Boolean,
        val firstName: String,
        val lastName: String,
        val email: String,
        val registrationDate: LocalDate,
        val dateOfBirth: LocalDate,
        val gender: String,
        val phone1: String,
        val phone2: String,
        val whatsapp: String,
        val photo: String,
        val addressString: String,
        val neighborhood: String,
        val zipCode: String,
        val city: String,
        val lastLogin: Long,
        val password: String,
)

fun UserModel.toDaoModel(): User =
        User(
                id = this.id,
                cpf = this.cpf,
                active = this.active,
                firstName = this.firstName,
                lastName = this.lastName,
                email = this.email,
                registrationDate = this.registrationDate.toDateTimeMinutes(),
                dateOfBirth = this.dateOfBirth.toDateTimeDays(),
                gender = this.gender,
                phone1 = this.phone1,
                phone2 = this.phone2,
                whatsapp = this.whatsapp,
                photo = this.photo,
                addressString = this.addressString,
                neighborhood = this.neighborhood,
                zipCode = this.zipCode,
                city = this.city,
                lastLogin = this.lastLogin,
                hash = password.toHash(),
        )
