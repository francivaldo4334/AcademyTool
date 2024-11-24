<template>
  <v-select v-model="localState.modalityPayment" density="compact" variant="outlined" :items="modalityPayments"
    hide-details>
  </v-select>
  <v-text-field density="compact" variant="outlined" hide-details v-model="localState.value" v-money="money">
  </v-text-field>
</template>
<script setup lang="ts">
import { computed } from 'vue';
import { defineProps } from 'vue';
import { useI18n } from 'vue-i18n';
const { t } = useI18n()
const props = defineProps({
  formState: {
    type: Object,
    require: true
  }
});
const localState = computed(() => props.formState as any)
const modalityPayments = [
  {
    title: t('unique-payment'),
    value: 'unique-payment',
  },
  {
    title: t('monthly'),
    value: 'monthly',
  },
  {
    title: t('weekly'),
    value: 'weekly',
  },
  {
    title: t('biweekly'),
    value: 'biweekly',
  },
]
const money = {
  decimal: ',',
  thousands: '.',
  prefix: 'R$ ',
  precision: 2,
  masked: false
}
</script>
