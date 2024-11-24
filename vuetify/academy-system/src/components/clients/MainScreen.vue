<template>
  <BaseModluleWithLising :menuOptions="menuOptions" title="client">
    <template #search="{ action }">
      <v-text-field v-model="inputSearch" :prepend-inner-icon="Search" :label="$t('search')" variant="outlined"
        hide-details single-line density="compact" class="max-w-240" />
      <v-btn color="primary" class="height-40 ma-0" @click="action">
        <span>{{ $t('search') }}</span>
      </v-btn>
      <v-spacer />
    </template>

    <template #select-range-per-page>
      <v-select label="Itens por página" density="compact" variant="outlined" :items="[5, 10, 15]" hide-details
        class="max-w-180" />
    </template>

    <template #select-filters>
      <filter-selection :list="filters" />
    </template>

    <template #icon-btn-add>
      <UserRoundPlus />
    </template>

    <template #new-item-modal-title>
      {{ $t(formStepTitle) }}
    </template>

    <template #new-item-modal-form="{ formState }">
      <v-window v-model="formStep" class="pa-3 fill-height text-on-background" style="min-height: 400px;">
        <v-window-item :value="0">
          <StudentForm :form="formState" />
        </v-window-item>
        <v-window-item :value="1">
          <AddressForm :form="formState" />
        </v-window-item>
        <v-window-item :value="2">
          <RegisterForm :form="formState" />
        </v-window-item>
      </v-window>
    </template>

    <template #new-item-modal-actions="{ onClose, isValid, onSubmit }">
      <v-btn v-if="formStep > 0" variant="plain" :text="$t('to-back')" :prepend-icon="Undo" @click="formStep--" />
      <v-spacer />
      <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="closeModal(onClose)" />
      <v-btn v-if="formStep > 1" color="primary" variant="tonal" :text="$t('save')"
        @click="isValid(() => onSubmit())" />
      <v-btn v-else color="primary" variant="tonal" :text="$t('next')" @click="isValid(() => formStep++)" />
    </template>
  </BaseModluleWithLising>
</template>

<script setup lang="ts">
import { ref, reactive, inject, computed } from "vue";
import { MenuItem } from "@/components/BaseModluleWithLising";
import BaseModluleWithLising from "@/components/BaseModluleWithLising.vue";
import { Search, BookmarkX, BookmarkCheck, Cake, UserRoundX, UserRoundPlus, Undo } from "lucide-vue-next";
import FilterSelection from "@/components/fields/FilterSelection.vue";
import Domain from "@/composables/domain/Domain";
import StudentForm from "./forms/StudentForm.vue";
import AddressForm from "./forms/AddressForm.vue";
import RegisterForm from "./forms/RegisterForm.vue";
import { z } from "zod";

// Injeção de dependências
const domain = inject("db") as Domain;

// Estados reativos
const inputSearch = ref("");
const formStep = ref(0);
const filters = reactive([
  { icon: BookmarkX, tip: "debtors", checked: false },
  { icon: BookmarkCheck, tip: "debited", checked: false },
  { icon: Cake, tip: "birthday", checked: false },
  { icon: UserRoundX, tip: "absent", checked: false },
]);

// Computed para título do formulário
const formStepTitle = computed(() =>
  formStep.value === 0 ? "student-data" : formStep.value === 1 ? "address" : "register"
);

// Configuração de opções do menu
const menuOptions: MenuItem<any>[] = [
  {
    key: 0,
    name: "student",
    filters: {
      search: () => { },
      "select-range-per-page": () => { },
      "select-filters": () => { },
    },
    repository: domain.users,
    scheme: z.object(
      {
        firstName: z.string().max(80),
        lastName: z.string().max(80),
        cpf: z.string().transform((it: string) => it.replace(/\D/g, '')),
        birthday: z.string().date().transform(it => new Date(it)),
        gender: z.enum(["male", "female", "other", ""]).default(""),
        mail: z.string().email().default(""),
        phone: z.string().transform(it => it.replace(/\D/g, '')).default(""),
        whatsapp: z.string().transform(it => it.replace(/\D/g, '')).default(""),
        addressString: z.string().default(""),
        city: z.string().default(""),
        neighborhood: z.string().default(""),
        street: z.string().default(""),
        zipCode: z.string().default(""),
        addressNumber: z.string().default(""),
        reference: z.string().default(""),
        isMonthlyPlan: z.boolean().default(true),
        startDate: z.string().date().transform(it => new Date(it)),
        endDate: z.string().date().transform(it => new Date(it)).nullable().default(null),
        modality: z.number().nullable().default(null),
        observation: z.string().default(""),
      }
    ),
  },
  {
    key: 1,
    name: "class",
    filters: {},
    repository: domain.users,
    scheme: z.object({}),
  },
  {
    key: 2,
    name: "birthday",
    filters: {},
    repository: domain.users,
    scheme: z.object({

    }),
  },
];
// Funções utilitárias
function closeModal(onClose: () => void) {
  onClose();
  formStep.value = 0;
}
</script>

<style scoped>
.max-w-240 {
  max-width: 240px;
}

.max-w-180 {
  max-width: 180px;
}

.text-on-background {
  color: rgb(var(--v-theme-on-background));
}
</style>
