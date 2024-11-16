<template>
  <v-dialog v-model="state.isOpenCreateModal" width="600px">

    <v-card>
      <v-card-title class="text-h6 font-weight-regular justify-space-between d-flex">
        <span>{{ $t(seasons[state.formStep]) }}</span>
        <v-item-group v-model="state.formStep">
          <v-item v-for="(it, id) in seasons" :key="it" v-slot="{ isSelected }" :value="id">
            <v-btn icon class="btn-record" @click="state.setStep(id)" variant="text" size="32">
              <DotIcon v-if="!isSelected" color="rgb(var(--v-theme-on-surface))" />
              <CircleDot v-else color="rgb(var(--v-theme-on-surface))" />
            </v-btn>
          </v-item>
        </v-item-group>
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
          <v-btn v-if="state.formStep > 1" color="primary" variant="tonal" :text="$t('save')"
            @click="onSave"></v-btn>
          <v-btn v-else color="primary" variant="tonal" :text="$t('next')" @click="toNext"></v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
import { Undo, DotIcon, CircleDot } from "lucide-vue-next"
import { useTemplateRef, inject } from "vue"
import { VForm } from "vuetify/components"
import AddressForm from "@/components/clients/screens/modals/forms/AddressForm.vue"
import StudentForm from "@/components/clients/screens/modals/forms/StudentForm.vue"
import RegisterForm from "@/components/clients/screens/modals/forms/RegisterForm.vue"
import Domain from "@/composables/domain/Domain"
import StudentModel from "@/composables/domain/models/StudentModel"

const form = useTemplateRef<VForm>("form")
const state = useClientsStore()
const seasons = {
  0: 'student-data',
  1: 'address',
  2: 'register',
}
const domain = inject("db") as Domain 
async function toNext() {
  if (!form.value) return;
  const { valid } = await form.value.validate()
  if (valid) {
    state.nextStep()
  }
}
function onSave() {
  domain.users.add(
    new StudentModel({
      cpf: "",
      active: true,
      firstName: "",
      lastName: "",
      email: "",
      dateOfBirth: new Date(),
      gender: "",
      phone: "",
      whatsapp: "",
      photo: "",
      addressString: "",
      neighborhood: "",
      zipCode: "",
      city: "",
    }),
    it => {
      state.closeCreateModal()
      console.log(it)
    }
  )
}
</script>


<style scoped>
.btn-record {
  background: rgb(var(--v-theme-surface)) !important;
}
</style>
