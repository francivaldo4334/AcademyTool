package br.com.pwrftctrl.core.presenter.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

fun loadFields(vararg fieldName: String): Map<String, MutableState<String>> {
    return fieldName.associateWith{mutableStateOf("")}
}

abstract class Form(private val formName: String? = null, vararg fieldName: String) {
    private val fields: Map<String, MutableState<String>> = loadFields(*fieldName)
    private var errorMessages: MutableMap<String, MutableState<String>> = loadFields(*fieldName).toMutableMap()
    private val forms: MutableMap<String, Form> = mutableMapOf()
    public var isValid = mutableStateOf(false)

    operator fun plus(form: Form): Form {
        this.forms[form.toString()] = form
        return this
    }
    open fun getValidateFieldMessage(fieldName: String, value: String): String? = null

    fun validateField(fieldName: String, value: String, setMessageErrors: Boolean = true): Boolean {
        var isValid = true
        getValidateFieldMessage(fieldName, value)?.let{ message -> 
            if (setMessageErrors){
                errorMessages[fieldName]?.value = message 
            }
            isValid = false
        }
        return isValid
    }
    abstract fun onAction()

    fun getForm(formName: String): Form {
        return getForms()[formName]!!
    } 

    fun getForms(): Map<String, Form> {
        return linkedMapOf<String, Form>().apply { 
            this[this@Form.toString()] = this@Form 
            this.putAll(this@Form.forms)
        }.toMap()
    }
    fun getFormNames(): List<String> {
        return this.getForms().map{ it.value.toString()}
    }

    fun getField(fieldName: String): MutableState<String>? {
        return this.getFields()[fieldName]
    }

    fun getFields(): Map<String, MutableState<String>> {
        return this.fields
    }

    fun getErrorMessage(fieldName: String): MutableState<String>? {
        return this.getErrorMessages()[fieldName]
    }

    fun getErrorMessages(): MutableMap<String, MutableState<String>> {
        val allErrorMessages = this.errorMessages
        this.forms.forEach { (_, form) ->
            allErrorMessages.putAll(form.getErrorMessages())
        }
        return allErrorMessages
    }

    fun validation(setMessageErrors: Boolean = true): Boolean {
        var isValid = true
        this.getFields().forEach{ (key, value) ->
            if (!this@Form.validateField(key, value.value,setMessageErrors)){
                isValid = false
            }
        }
        this.isValid.value = isValid
        return isValid

    }

    fun onSubmit() {
        if (validation()) {
            onAction()
            cleanErrors()
        }
    }

    fun cleanErrors() {
        errorMessages.clear()
    }

    override fun toString(): String {
        return formName ?: ""
    }
}
