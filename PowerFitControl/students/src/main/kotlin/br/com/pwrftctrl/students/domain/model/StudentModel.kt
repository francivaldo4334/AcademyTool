package br.com.pwrftctrl.students.domain.model

import br.com.pwrftctrl.core.domain.models.UserModel
import java.time.LocalDate

data class StudentModel(
        val id: Int,
        // Dados do aluno
        val name: String,
        val lastName: String,
        val cpf: String,
        val dateOfBirth: LocalDate,
        val email: String,
        val phone1: String,
        val phone2: String,
        val whatsapp: String,
        val gender: String,
        val avaterUrl: String,
        // Endereço
        val city: String,
        val neighborhood: String,
        val street: String,
        val avenue: String,
        val zipCode: String,
        val number: String,
        val reference: String,
        // Matricula
        val startDate: LocalDate,
        val dueDate: LocalDate,
        val modality: Int,
        val observation: String
)

fun StudentModel.toUserModel(): UserModel {
        return UserModel(
                id = this.id,
                cpf = this.cpf,
                firstName = this.name,
                lastName = this.lastName,
                email = this.email,
                dateOfBirth = this.dateOfBirth,
                gender = this.gender,
                phone1 = this.phone1,
                phone2 = this.phone2,
                whatsapp = this.whatsapp,
                photo = this.avaterUrl,
                neighborhood = this.neighborhood,
                zipCode = this.zipCode,
                city = this.city,
        )
}

fun StudentModel.toRegistrationModel(): RegistrationModel {
        return RegistrationModel(
                id = this.id,
                startDate = this.startDate,
                dueDate = this.dueDate,
                modality = this.modality,
                observation = this.observation,
                student = this.id,
        )
}
