<template>
  <BaseModluleWithLising :menuOptions="menuOptions" title="workout">
    <template #icon-btn-add>
      <ClipboardPlus />
    </template>
    <template #new-item-modal-form="{ formState }">
      <div class="pa-3 text-on-background d-flex flex-column ga-2">
        <ModalityForm :form-state="formState" />
      </div>
    </template>
    <template #new-item-modal-actions="{ onClose, isValid, onSubmit }">
      <v-spacer />
      <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="onClose" />
      <v-btn color="primary" variant="tonal" :text="$t('save')" @click="isValid(() => onSubmit())" />
    </template>
  </BaseModluleWithLising>
</template>
<script setup lang="ts">
import IModelDomain from '@/composables/domain/models/IModelDomain';
import { MenuItem } from '../BaseModluleWithLising';
import BaseModluleWithLising from '../BaseModluleWithLising.vue';
import { inject } from 'vue';
import { z } from 'zod';
import Domain from '@/composables/domain/Domain';
import ModalityForm from "./forms/ModalityForm.vue"
import { useI18n } from "vue-i18n"
import { ClipboardPlus } from "lucide-vue-next"
const { t, d, n } = useI18n()
const domain = inject("domain") as Domain;
const menuOptions: MenuItem<IModelDomain>[] = [
  {
    key: 2,
    name: "modality",
    filters: {},
    repository: domain.modalities,
    scheme: z.object({
      title: z.string().min(5),
      value: z.string().transform(it => parseInt(it.replace(/\D/g, '') || "0")),
      description: z.string().default(""),
      modalityPayment: z.enum(["unique-payment", "monthly", "weekly", "biweekly"]),
      active: z.boolean().default(true),
    }),
    tableScheme: z.object({
      title: z.string().default(""),
      createAt: z.date().transform(it => d(it, 'short', 'pt-BR')),
      modalityPayment: z.string().transform(it => t(it)),
      description: z.string(),
      value: z.number().transform(it => n(it, 'currency', 'pt-BR')),
    })
  },
]
</script>
