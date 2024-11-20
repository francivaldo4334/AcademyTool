<template>
  <v-dialog width="600px" persistent v-model="state.isOpenModalCreate" color="surface-variant dencity-100">
    <v-card>
      <v-card-title class="text-h6 font-weight-bold font-weight-regular justify-space-between d-flex mt-4">
        Teste
      </v-card-title>
      <v-form ref="form">
        <v-card variant="outlined" class="ma-2 pa-3" color="surface-light">
          <div style="color: rgb(var(--v-theme-on-background));">
            <v-text-field :label="$t('title')" v-model="state.form.description" variant="outlined" density="compact" />
            <v-select :label="$t('payment-modality')" v-model="state.form.modalityPayment" variant="outlined"
              density="compact" :items="paymentModalities" />
            <v-text-field :label="$t('value')" v-model="state.form.value" variant="outlined" density="compact"
              type="number" />
          </div>
        </v-card>
        <v-divider />
        <v-card-actions class="justify-end">
          <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="state.closeModalCreate"></v-btn>
          <v-btn color="primary" variant="tonal" :text="$t('save')" @click="onSubmit"></v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-dialog>
</template>
<script setup lang="ts">
import { useModalityStore } from "@/stores/ModalityStore"
import { PaymentModality } from "@/composables/domain/models/ModalityModel"
const state = useModalityStore()
const paymentModalities = [
  "unique-payment",
  "monthly",
  "weekly",
  "biweekly"
] as PaymentModality[]
</script>
