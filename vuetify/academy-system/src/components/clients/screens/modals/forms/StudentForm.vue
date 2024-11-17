<template>
  <v-card-tex class="d-flex flex-column ga-4">
    <div class="d-flex">
      <v-col class="fill-width pa-0 ma-0 h-auto">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="Smile" :rules="[rules.required]" v-model="store.formSteps.student.name"/>
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="Smile" :rules="[rules.required]" v-model="store.formSteps.student.lastName"/>
      </v-col>
      <InputImageFile class="ml-4" v-model="store.formSteps.student.avatar"/>
    </div>
    <v-row class="fill-width d-flex pa-0 ma-0 ga-4">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" hide-details="auto"
        :prepend-inner-icon="IdCard" placeholder="XX.XXX.XXX-XX" :rules="[rules.required]" v-model="store.formSteps.student.cpf"/>
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :prepend-inner-icon="Cake" type="date" style="max-width: 220px;" v-model="store.formSteps.student.birthday"/>
    </v-row>
    <v-text-field variant="outlined" density="compact" :label="$t('gender')" hide-details="auto"
      :prepend-inner-icon="Blend" type="gender" :placeholder="$t('enger')" :rules="[]" 
      v-model="store.formSteps.student.gender"/>
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto"
      :prepend-inner-icon="Mail" type="email" :placeholder="$t('example-mail')" :rules="[rules.email]" 
      v-model="store.formSteps.student.email"/>
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" placeholder="(XX) X XXXX-XXXX" :rules="[rules.phone]" 
      v-model="store.formSteps.student.phone"/>
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details density="compact"/>
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" placeholder="(XX) X XXXX-XXXX" :rules="[rules.phone]" 
      v-model="store.formSteps.student.whatsapp"/>
  </v-card-tex>
</template>

<script lang="ts" setup>
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, Smile, Mail, IdCard, Phone, Cake, Blend } from "lucide-vue-next"
import { ref } from "vue"
import { useI18n } from "vue-i18n"
import { useClientsStore } from "@/stores/ClientsStore"

const store = useClientsStore()
const { t } = useI18n()
const rules = ref({
  required: (it: string) => !!it || t("required-field"),
  email: (value: string) => {
    const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return !value || pattern.test(value) || t('invalid-email')
  },
  phone: (value: string) => {
    const pattern = /^\(?[0-9]{1,3}\)?[-\s]?[9]?[-\s]?[-\s]?[0-9]{4}[-\s]?[0-9]{4}$/
    return !value || pattern.test(value) || t('invalid-phone')
  }
})
</script>
<style></style>
