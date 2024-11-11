<template>
  <v-dialog v-model="state.isOpenCreateModal" width="auto">
    <v-card min-widht="400" min-height="400">
      <v-card-actions class="d-flex justify-end">
        <v-btn class="text-none" rounded text="cancel" @click="state.closeCreateModal"></v-btn>
        <v-btn class="text-none" rounded text="Send" variant="flat" @click="state.closeCreateModal"></v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { useClientsStore } from "@/stores/ClientsStore"
export default {
  data() {
    return {
      state: useClientsStore(),
    }
  }
}
</script>

<style></style>
