package br.com.pwrftctrl.students.presenter.forms

import br.com.pwrftctrl.core.presenter.utils.Form
import br.com.pwrftctrl.core.utils.R

class FormStudentData :
        Form(formName = R.strings.student, *Field.values().map { it.name }.toTypedArray()) {
    enum class Field {
        FIRST_NAME,
        LAST_NAME,
        CPF,
        BIRTHDATE,
        EMAIL,
        PHONE_1,
        PHONE_2,
        WHATSAPP,
    }

    override fun getValidateFieldMessage(fieldName: String, value: String): String? {
        return when (fieldName) {
            Field.FIRST_NAME.name,
            Field.LAST_NAME.name,
            Field.CPF.name,
            Field.BIRTHDATE.name,
            Field.PHONE_1.name -> {
                val errors = mutableListOf<String>()
                if (value.isEmpty()) {
                    errors.add("Este campo é obrigatorio!")
                }
                if (errors.isNotEmpty()) errors.joinToString(",") else null
            }
            else -> null
        }
    }

    override fun onAction() {}
}

class FormStudentAddress :
        Form(formName = R.strings.address, *Field.values().map { it.name }.toTypedArray()) {
    enum class Field {
        ADDRESS,
        NEIGHBORHOOD,
        AVENUE,
        CITY,
        STREET,
        ZIP_CODE,
        NUMBER,
        REFERENCE,
    }

    override fun onAction() {}
}

class FormStudentRegistrationData :
        Form(
                formName = R.strings.student_register,
                *Field.values().map { it.name }.toTypedArray()
        ) {
    enum class Field {
        START_DATE,
        END_DATE,
        MODALITY,
        OBSERVATION,
    }

    override fun getValidateFieldMessage(fieldName: String, value: String): String? {
        return when (fieldName) {
            Field.OBSERVATION.name, -> {
                val errors = mutableListOf<String>()
                if (value.isEmpty()) {
                    errors.add("Este campo é obrigatorio!")
                }
                if (errors.isNotEmpty()) errors.joinToString(",") else null
            }
            else -> null
        }
    }

    override fun onAction() {}
}
