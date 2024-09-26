package br.com.pwrftctrl.core.presenter.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

fun loadFields(vararg fieldName: String): Map<String, MutableState<String>> {
    return mapOf(
        *fieldName.map { it to mutableStateOf("") }.toTypedArray()
    )
}

abstract class Form(vararg fieldName: String) {
    private val fields: Map<String, MutableState<String>> = loadFields(*fieldName)
    private var errorMessages: MutableMap<String, String> = mutableMapOf()
    private var forms: MutableMap<String, Form>? = null

    operator fun plus(form: Form): Form {
        if (this.forms == null)
            this.forms = mutableMapOf()
        this.forms!![form.toString()] = form
        return this
    }
    abstract fun validateField(fieldName: String): String?

    abstract fun onAction()

    fun getField(fieldName: String): MutableState<String>? {
        return this.getFields()[fieldName]
    }

    fun getFields(): Map<String, MutableState<String>> {
        val fields = this.fields.toMutableMap()
        this.forms?.forEach { (key, value) ->
            val valueFields = value.getFields()
            fields += valueFields
        }
        return fields
    }

    fun getErrorMessage(fieldName: String): String? {
        return this.getErrorMessages()[fieldName]
    }

    fun getErrorMessages(): MutableMap<String, String> {
        val errorMessages = this.errorMessages
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