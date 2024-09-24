package br.com.pwrftctrl.students.presenter.forms

import br.com.pwrftctrl.core.presenter.utils.Form
import kotlin.collections.mapOf
import kotlin.collections.mutableMapOf
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class FormStudent() : Form {
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
  override val fields = mapOf<String, MutableState<String>>(
      FIRST_NAME to mutableStateOf(""), 
      LAST_NAME to mutableStateOf(""), 
      CPF to mutableStateOf(""), 
      BIRTHDATE to mutableStateOf(""), 
      EMAIL to mutableStateOf(""), 
      PHONE_1 to mutableStateOf(""), 
      PHONE_2 to mutableStateOf(""), 
      WHATSAPP to mutableStateOf(""), 
      ADDRESS to mutableStateOf(""), 
      NEIGHBORHOOD to mutableStateOf(""), 
      AVENUE to mutableStateOf(""), 
      STREET to mutableStateOf(""), 
      ZIP_CODE to mutableStateOf(""), 
      NUMBER to mutableStateOf(""), 
      REFERENCE to mutableStateOf(""), 
      START_DATE to mutableStateOf(""), 
      END_DATE to mutableStateOf(""), 
      MODALITY to mutableStateOf(""), 
      OBSERVATION to mutableStateOf(""), 
  )
  override var messageErrors = mutableMapOf<String, String>()
  override fun validateField(fieldName: String): String? {
    return null
  }
  override fun onAction() {

  }
}
