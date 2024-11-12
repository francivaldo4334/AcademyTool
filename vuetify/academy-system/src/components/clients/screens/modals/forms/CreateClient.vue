<template>
  <v-col class="pa-4 ma-0">
    <v-row class="pa-0 ma-0">
      <v-col class="fill-width pa-0 ma-0">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="UserPen" />
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="UserPen" />
      </v-col>
      <InputImageFile class="ml-4 mb-4" />
    </v-row>
    <v-row class="fill-width pa-0 ma-0">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" class="mr-4" hide-details="auto"
        :prepend-inner-icon="UserSearch" />
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :prepend-inner-icon="Cake">
        <v-menu activator="parent">
          <v-date-picker elevation="24"></v-date-picker>
        </v-menu>
      </v-text-field>
    </v-row>
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto" class="mt-4 mb-4"
      :prepend-inner-icon="Mail" />
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" />
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details />
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" />
  </v-col>
</template>

<script setup lang="ts">
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, UserPen, Mail, UserSearch, Phone, Cake } from "lucide-vue-next"
</script>
<style></style>
