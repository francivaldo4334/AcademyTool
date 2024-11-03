package br.com.pwrftctrl.students.domain.model

import br.com.pwrftctrl.core.domain.utils.toDateDays
import br.com.pwrftctrl.core.domain.utils.toDateTimeMinutes
import br.com.pwrftctrl.students.data.models.Registration
import java.time.LocalDate

data class RegistrationModel(
        val id: Int,
        val active: Boolean = true,
        val student: Int,
        val registrationDate: LocalDate? = null,
        val startDate: LocalDate,
        val dueDate: LocalDate,
        val situation: String? = null,
        val modality: Int,
        val observation: String,
        val inDebit: Boolean = false,
)

fun RegistrationModel.toModelDao(): Registration {
        return Registration(
                id = this.id,
                active = this.active,
                student = this.student,
                registrationDate = this.registrationDate?.toDateTimeMinutes(),
                startDate = this.startDate.toDateDays(),
                dueDate = this.dueDate.toDateDays(),
                situation = if (this.situation != null) this.situation else "",
                modality = this.modality,
                observation = this.observation,
                inDebit = this.inDebit,
        )
}
