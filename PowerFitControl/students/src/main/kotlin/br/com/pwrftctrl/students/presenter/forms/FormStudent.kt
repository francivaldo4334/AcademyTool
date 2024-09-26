package br.com.pwrftctrl.students.presenter.forms

import br.com.pwrftctrl.core.presenter.utils.Form

class FormStudent : Form(
    FIRST_NAME,
    LAST_NAME,
    CPF,
    BIRTHDATE,
    EMAIL,
    PHONE_1,
    PHONE_2,
    WHATSAPP,
    ADDRESS,
    NEIGHBORHOOD,
    AVENUE,
    STREET,
    ZIP_CODE,
    NUMBER,
    REFERENCE,
    START_DATE,
    END_DATE,
    MODALITY,
    OBSERVATION,
) {
    companion object {
        val FIRST_NAME = "FIRST_NAME"
        val LAST_NAME = "LAST_NAME"
        val CPF = "CPF"
        val BIRTHDATE = "BIRTHDATE"
        val EMAIL = "EMAIL"
        val PHONE_1 = "PHONE_1"
        val PHONE_2 = "PHONE_2"
        val WHATSAPP = "WHATSAPP"
        val ADDRESS = "ADDRESS"
        val NEIGHBORHOOD = "NEIGHBORHOOD"
        val AVENUE = "AVENUE"
        val STREET = "STREET"
        val ZIP_CODE = "ZIP_CODE"
        val NUMBER = "NUMBER"
        val REFERENCE = "REFERENCE"
        val START_DATE = "START_DATE"
        val END_DATE = "END_DATE"
        val MODALITY = "MODALITY"
        val OBSERVATION = "OBSERVATION"
    }

    override fun validateField(fieldName: String): String? {
        return null
    }

    override fun onAction() {

    }
}
