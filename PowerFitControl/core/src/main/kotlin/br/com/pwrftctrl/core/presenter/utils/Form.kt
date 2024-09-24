package br.com.pwrftctrl.core.presenter.utils

import kotlin.collections.MutableMap
import androidx.compose.runtime.MutableState

interface Form  {
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
