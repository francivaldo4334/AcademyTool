<template>
  <v-col class="pa-4 ma-0">
    <v-row class="pa-0 ma-0">
      <v-col class="fill-width pa-0 ma-0">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="Smile" />
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="Smile" />
      </v-col>
      <InputImageFile class="ml-4 mb-4" />
    </v-row>
    <v-row class="fill-width pa-0 ma-0">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" class="mr-4" hide-details="auto"
        :prepend-inner-icon="IdCard" placeholder="XX.XXX.XXX-XX" />
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :prepend-inner-icon="Cake" type="date" />
    </v-row>
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto" class="mt-4 mb-4"
      :prepend-inner-icon="Mail" type="email" :placeholder="$t('example-mail') + '@gmail.com'" />
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" placeholder="(XX) X XXXX-XXXX" />
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details />
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" placeholder="(XX) X XXXX-XXXX" />
  </v-col>
</template>

<script setup lang="ts">
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, Smile, Mail, IdCard, Phone, Cake } from "lucide-vue-next"
</script>
<style>
.v-date-picker .v-btn--icon {
  background: rgb(var(--v-theme-surface)) !important;
}

.v-date-picker .v-btn__content {
  color: rgb(var(--v-theme-on-background)) !important;
}
</style>
