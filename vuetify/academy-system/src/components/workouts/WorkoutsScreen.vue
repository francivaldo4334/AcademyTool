<template>
  <p class="text-h5 mb-4">{{ $t('workout', 2) }}</p>
  <v-tabs v-model="screen" color="primary" class="mb-4">
    <v-tab v-for="it in screens" :key="it" :value="it">{{ $t(it, 2) }}</v-tab>
  </v-tabs>
  <v-tabs-window v-model="screen">
    <v-tabs-window-item value="modality">
      <ModalitiesScreen />
    </v-tabs-window-item>
  </v-tabs-window>
</template>
<script setup lang="ts">
import { ref } from "vue"
import ModalitiesScreen from "./screens/ModalitiesScreen.vue"
const screens = [
  "modality"
]
const screen = ref("modality")
</script>
