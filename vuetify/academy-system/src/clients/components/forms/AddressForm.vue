<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <v-text-field :label="$t('address')" density="compact" variant="outlined" hide-details="auto"
      v-model="localForm.addressString" />
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('city')" density="compact" variant="outlined" hide-details="auto"
        v-model="localForm.city" />
      <v-text-field :label="$t('neighborhood')" density="compact" variant="outlined" hide-details="auto"
        v-model="localForm.neighborhood" />
    </v-row>
    <v-text-field :label="$t('street')" density="compact" variant="outlined" hide-details="auto"
      v-model="localForm.street" />
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('zip-code')" density="compact" variant="outlined" hide-details="auto"
        v-model="localForm.zipCode" />
      <v-text-field :label="$t('address-number')" density="compact" variant="outlined" hide-details="auto"
        v-model="localForm.addressNumber" />
    </v-row>
    <v-text-field :label="$t('reference')" density="compact" variant="outlined" hide-details="auto"
      v-model="localForm.reference" />
  </v-col>
</template>

<script lang="ts" setup>
import { computed } from "vue";
import { defineProps } from "vue"
const props = defineProps({
  form: {
    type: Object,
    required: true,
  }
});
const localForm = computed(() => props.form)
</script>

<style></style>
