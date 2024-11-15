<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <v-row class="ga-3 ma-0 pa-0">
      <v-text-field :label="$t('city')" density="compact" variant="outlined" hide-details="auto"/>
      <v-text-field :label="$t('neighborhood')" density="compact" variant="outlined" hide-details="auto"/>
    </v-row>
    <v-text-field :label="$t('street')" density="compact" variant="outlined" hide-details="auto"/>
    <v-text-field :label="$t('reference')" density="compact" variant="outlined" hide-details="auto"/>
  </v-col>
</template>

<script lang="ts" setup>
</script>

<style></style>
