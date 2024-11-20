<template>
  <v-data-table-virtual :items="state.modalities" :headers="headers" class="bg-background"
    :no-data-text="$t('no-data')">
  </v-data-table-virtual>
</template>
<script setup lang="ts">
import { reactive } from "vue"
import ModalityModel from "@/composables/domain/models/ModalityModel"
import { useI18n } from "vue-i18n"
import { useModalityStore } from "@/stores/ModalityStore"
const state = useModalityStore()
const { t } = useI18n()
type Item = {
  title: string,
  align: "center" | "start" | "end",
  key: keyof ModalityModel
}
const headers = reactive([
  { title: t("modality"), align: "start", key: "description" },
  { title: t("payment-modality"), align: "center", key: "modalityPayment" },
  { title: t("value"), align: "end", key: "value" },
] as Item[])
</script>
