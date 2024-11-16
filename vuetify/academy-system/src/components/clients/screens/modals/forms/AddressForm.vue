<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <v-text-field :label="$t('address')" density="compact" variant="outlined" hide-details="auto"
      v-model="store.formSteps.address.strAddress"/>
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('city')" density="compact" variant="outlined" hide-details="auto"
        v-model="store.formSteps.address.city"/>
      <v-text-field :label="$t('neighborhood')" density="compact" variant="outlined" hide-details="auto"
        v-model="store.formSteps.address.neighborhood"/>
    </v-row>
    <v-text-field :label="$t('street')" density="compact" variant="outlined" hide-details="auto"
      v-model="store.formSteps.address.street"/>
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('zip-code')" density="compact" variant="outlined" hide-details="auto"
        v-model="store.formSteps.address.zipCode"/>
      <v-text-field :label="$t('address-number')" density="compact" variant="outlined" hide-details="auto"
        v-model="store.formSteps.address.addressNumber"/>
    </v-row>
    <v-text-field :label="$t('reference')" density="compact" variant="outlined" hide-details="auto"
      v-model="store.formSteps.address.reference"/>
  </v-col>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
const store = useClientsStore()
</script>

<style></style>
