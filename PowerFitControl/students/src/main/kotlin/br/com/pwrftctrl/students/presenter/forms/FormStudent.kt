package br.com.pwrftctrl.students.presenter.forms

import br.com.pwrftctrl.core.presenter.utils.Form

class FormStudentData : Form(
    formName="Dados pessoais",
    *Field.values().map{it.name}.toTypedArray()
) {
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

    override fun onAction() {

    }
}
class FormStudentAddress : Form(
    formName="Endereço do aluno",
    *Field.values().map{it.name}.toTypedArray()
) {
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

    override fun onAction() {

    }
}
class FormStudentRegistrationData : Form(
    formName="Informações de matricula",
    *Field.values().map{it.name}.toTypedArray()
) {
    enum class Field {
        START_DATE,
        END_DATE,
        MODALITY,
        OBSERVATION,
    }

    override fun onAction() { }
}
