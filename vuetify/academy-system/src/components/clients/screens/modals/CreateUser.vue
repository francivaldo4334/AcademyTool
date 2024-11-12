<template>
  <v-dialog v-model="state.isOpenCreateModal" width="700px">
    <v-card>
      <div class="ma-0 d-flex align-center">
        <div style="width: 120px; margin: 32px 0 32px 32px;">
          <v-range-slider color="primary" max-width="20" direction="vertical" :model-value="[2, 2]" :ticks="seasons"
            max="2" show-ticks="always" readonly="true" hide-details>
            <template v-slot:tick-label="{ tick }">
              <div style="width: 100px;">
                {{ $t(tick.label) }}
              </div>
            </template>
          </v-range-slider>
        </div>
        <v-divider vertical />
        <v-col class="d-flex flex-column justify-end">
          <v-card-tex class="fill-height">
            <Form />
          </v-card-tex>
          <v-card-actions class="d-flex justify-end pa-0 align-end">
            <v-btn variant="plain" :text="$t('to-back')" :prepend-icon="toBackIcon"
              @click="state.closeCreateModal"></v-btn>
            <v-spacer />
            <v-btn variant="plain" :text="$t('cancel')" @click="state.closeCreateModal"></v-btn>
            <v-btn color="primary" variant="tonal" :text="$t('save')" @click="state.closeCreateModal"></v-btn>
          </v-card-actions>
        </v-col>
      </div>
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

<style scoped></style>
