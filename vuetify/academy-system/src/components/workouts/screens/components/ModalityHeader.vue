<template>
  <v-row class="ma-0 fill-width align-center pb-4">
    <modal-create-modality />
    <v-btn icon :size="40" class="ml-2" color="primary" rounded>
      <Plus />
      <v-tooltip activator="parent" location="bottom">
        {{ $t('add-new-modality') }}
      </v-tooltip>
    </v-btn>
  </v-row>
</template>
<script setup lang="ts">
import ModalCreateModality from '../modals/CreateModality.vue'
import { Plus } from "lucide-vue-next"
</script>
