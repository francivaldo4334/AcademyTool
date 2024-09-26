package br.com.pwrftctrl.core.presenter.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

fun loadFields(vararg fieldName: String): Map<String, MutableState<String>> {
    return mapOf(
        *fieldName.map { it to mutableStateOf("") }.toTypedArray()
    )
}

open class Form(vararg fieldName: String) {
    private val fields: Map<String, MutableState<String>> = loadFields(*fieldName)
    private var errorMessages: MutableMap<String, String> = mutableMapOf()
    private var forms: MutableMap<String, Form>? = null
    fun validateField(fieldName: String): String? {
        TODO("Not yet implemented")
    }

    fun onAction() {
        TODO("Not yet implemented")
    }

    fun getField(fieldName: String): MutableState<String>? {
        if (fields.contains(fieldName)) {
            return fields.get(fieldName)
        }
        return null
    }

    fun getErrorMessages(): MutableMap<String, String> {
        var errorMessages = this.errorMessages
        this.forms?.forEach { (key, value) ->
            val valueErrorMessages = value.getErrorMessages()
            errorMessages += valueErrorMessages
        }
        return errorMessages
    }

    fun validation(): Boolean {
        var result = true
        this.fields.forEach{ (key, value) ->
            val message = validateField(key)
            if (message != null) {
                errorMessages[key] = message
                result = false
            }
        }
        return result
    }

    fun onSubmit() {
        if (validation()) {
            onAction()
            cleanErrors()
        }
    }

    fun cleanErrors() {
        errorMessages = mutableMapOf()
    }

}