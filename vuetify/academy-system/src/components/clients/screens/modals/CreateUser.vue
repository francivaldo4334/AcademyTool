<template>
  <v-dialog v-model="state.isOpenCreateModal" width="600px" persistent>

    <v-card>
      <v-card-title class="text-h6 font-weight-bold font-weight-regular justify-space-between d-flex mt-4">
        <span>{{ $t(seasons[state.formStep]) }}</span>
      </v-card-title>
      <v-form ref="form">
        <v-window v-model="state.formStep" class="pa-3 fill-height" style="min-height: 400px;">
          <v-window-item :value="0">
            <StudentForm />
          </v-window-item>
          <v-window-item :value="1">
            <AddressForm />
          </v-window-item>
          <v-window-item :value="2">
            <RegisterForm />
          </v-window-item>
        </v-window>
        <v-divider />
        <v-card-actions>
          <v-btn v-if="state.formStep > 0" variant="plain" :text="$t('to-back')" :prepend-icon="Undo"
            @click="state.prevStep"></v-btn>
          <v-spacer />
          <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="state.closeCreateModal"></v-btn>
          <v-btn v-if="state.formStep > 1" color="primary" variant="tonal" :text="$t('save')" @click="onSubmit"></v-btn>
          <v-btn v-else color="primary" variant="tonal" :text="$t('next')" @click="toNext"></v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
import { Undo } from "lucide-vue-next"
import { useTemplateRef } from "vue"
import { VForm } from "vuetify/components"
import StudentForm from "./forms/StudentForm.vue"
import AddressForm from "./forms/AddressForm.vue"
import RegisterForm from "./forms/RegisterForm.vue"

const form = useTemplateRef<VForm>("form")
const state = useClientsStore()
const seasons = {
  0: 'student-data',
  1: 'address',
  2: 'register',
}
async function toNext() {
  if (!form.value) return;
  const { valid } = await form.value.validate()
  if (valid) {
    state.nextStep()
  }
}
async function onSubmit() {
  if (!form.value) return;
  const { valid } = await form.value.validate()
  if (valid) {
    state.onCreateStudent()
  }
}
</script>


<style scoped>
.btn-record {
  background: rgb(var(--v-theme-surface)) !important;
}
</style>
