<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('start-date')" density="compact" variant="outlined" hide-details="auto" type="date"
        v-model="store.form.startDate" />
      <v-text-field :label="$t('end-date')" density="compact" variant="outlined" hide-details="auto" type="date"
        v-model="store.form.endDate" :disabled="store.form.isMonthlyPlan" />
    </v-row>
    <v-checkbox hide-details density="compact" v-model="store.form.isMonthlyPlan">
      <template v-slot:label>
        {{ $t('recurrent') }}
        <v-tooltip location="bottom">
          <template v-slot:activator="{ props }">
            <HelpCircle :size="16" class="ml-1" v-bind="props" color="blue">
            </HelpCircle>
          </template>
          {{ $t('recurrent-help') }}
        </v-tooltip>
      </template>
    </v-checkbox>
    <v-text-field :label="$t('modality')" density="compact" variant="outlined" hide-details="auto"
      v-model="store.form.modality" />
    <v-textarea :label="$t('observation')" density="compact" variant="outlined" hide-details="auto" counter
      v-model="store.form.observation" />
  </v-col>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
import { HelpCircle } from "lucide-vue-next"
const store = useClientsStore()
</script>

<style></style>
