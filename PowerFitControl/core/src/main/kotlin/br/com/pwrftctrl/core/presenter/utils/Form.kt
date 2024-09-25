package br.com.pwrftctrl.core.presenter.utils

import kotlin.collections.MutableMap
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.sun.source.tree.IfTree

interface IForm  {
  val fields: Map<String, MutableState<String>>
  var messageErrors: MutableMap<String, String>
  fun getField(fieldName: String): MutableState<String>?{
    if (fields.contains(fieldName)) {
      return fields.get(fieldName)
    }
    return null
  }
  fun getMessageError(fieldName: String): String? {
    if (messageErrors.contains(fieldName)) {
      return messageErrors.get(fieldName)
    }
    return null
  }
  fun validateField(fieldName:String): String?
  fun valid(): Boolean {
    var result = true
    for ((key, value) in fields) {
      val fieldValue = value.value
      val errorMessage = validateField(key)
      if (errorMessage != null) {
        messageErrors[key] = errorMessage
        result = false
      }
    }
    return result
  }
  fun onSubmit() {
    if(valid()){
      onAction()
      cleanErrors()
    }
  }
  fun cleanErrors() {
    messageErrors = mutableMapOf<String, String>()
  }
  fun onAction()
}

open class Form(
  override val fields: Map<String, MutableState<String>>,
  override var messageErrors: MutableMap<String, String> = mutableMapOf()
) : IForm {
  private var subform : Form? = null
  override fun validateField(fieldName: String): String? {
    TODO("Not yet implemented")
  }

  override fun onAction() {
    TODO("Not yet implemented")
  }

}

fun loadFields(vararg fieldName: String) : Map<String, MutableState<String>>{
  return mapOf(
    *fieldName.map { it to mutableStateOf("") }.toTypedArray()
  )
}