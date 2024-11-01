package br.com.pwrftctrl.students.domain.model

import java.time.LocalDate

class StudentModel(
        // Dados do aluno
        val name: String,
        val lastName: String,
        val cpf: String,
        val dateOfBirth: LocalDate,
        val email: String,
        val phone1: String,
        val phone2: String,
        val whatsapp: String,
        // Endereço
        val city: String,
        val neighborhood: String,
// TODO: Continuar implementação de registro de aluno
)
