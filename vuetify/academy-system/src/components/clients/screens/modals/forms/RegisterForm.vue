<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('start-date')" density="compact" variant="outlined" hide-details="auto" type="date"
        v-model="store.form.startDate" />
      <v-text-field :label="$t('end-date')" density="compact" variant="outlined" hide-details="auto" type="date"
        v-model="store.form.endDate" />
    </v-row>
    <v-text-field :label="$t('modality')" density="compact" variant="outlined" hide-details="auto"
      v-model="store.form.modality" />
    <v-textarea :label="$t('observation')" density="compact" variant="outlined" hide-details="auto" counter
      v-model="store.form.observation" />
  </v-col>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
const store = useClientsStore()
</script>

<style></style>
