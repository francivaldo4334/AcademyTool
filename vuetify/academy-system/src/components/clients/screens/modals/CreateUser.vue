<template>
  <v-dialog v-model="state.isOpenCreateModal" width="auto">
    <v-card>
      <v-row class="ma-0">
        <v-col class="pa-12">
          <v-range-slider direction="vertical" :model-value="[2, 2]" :ticks="seasons" max="2" show-ticks="always"
            readonly="true" hide-details>
            <template v-slot:tick-label="{ tick }">
              {{ $t(tick.label) }}
            </template>
          </v-range-slider>
        </v-col>
        <v-divider vertical class="ml-12"></v-divider>
        <v-col class="d-flex flex-column justify-end">
          <Form />
          <v-card-actions class="d-flex justify-end">
            <v-btn variant="plain" :text="$t('to-back')" :prepend-icon="toBackIcon"
              @click="state.closeCreateModal"></v-btn>
            <v-spacer />
            <v-btn variant="plain" :text="$t('cancel')" @click="state.closeCreateModal"></v-btn>
            <v-btn color="primary" variant="tonal" :text="$t('save')" @click="state.closeCreateModal"></v-btn>
          </v-card-actions>
        </v-col>
      </v-row>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { useClientsStore } from "@/stores/ClientsStore"
import { Undo } from "lucide-vue-next"
import Form from "./forms/CreateClient.vue"
export default {
  components: {
    Form
  },
  data() {
    return {
      state: useClientsStore(),
      seasons: {
        0: 'register',
        1: 'address',
        2: 'student',
      },
      toBackIcon: Undo
    }
  }
}
</script>

<style></style>
