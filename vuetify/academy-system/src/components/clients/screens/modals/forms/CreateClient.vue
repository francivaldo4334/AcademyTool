<template>
  <div class="pa-4 ma-0 d-flex flex-column" style="gap: 12px;">
    <div class="d-flex">
      <v-col class="fill-width pa-0 ma-0" style="height:auto;">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="Smile" :rules="[rules.required]" />
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="Smile" :rules="[rules.required]"/>
      </v-col>
      <InputImageFile class="ml-4" />
    </div>
    <v-row class="fill-width pa-0 ma-0">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" class="mr-4" hide-details="auto"
        :prepend-inner-icon="IdCard" placeholder="XX.XXX.XXX-XX" :rules="[rules.required]"/>
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :prepend-inner-icon="Cake" type="date" :rules="[rules.required]"/>
    </v-row>
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto" 
      :prepend-inner-icon="Mail" type="email" :placeholder="$t('example-mail')" />
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" placeholder="(XX) X XXXX-XXXX" />
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details density="compact"/>
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" placeholder="(XX) X XXXX-XXXX" />
  </div>
</template>

<script setup lang="ts">
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, Smile, Mail, IdCard, Phone, Cake } from "lucide-vue-next"
import { ref } from "vue"
import { useI18n } from "vue-i18n"
const { t } = useI18n()
const rules = ref({
  required: (it: string) => !!it || t("required-field")
})
</script>
<style>
</style>
