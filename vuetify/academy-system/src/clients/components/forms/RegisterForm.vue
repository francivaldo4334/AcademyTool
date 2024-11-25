<template>
  <v-col class="pa-0 ma-0 d-flex flex-column ga-3">
    <div class="ga-3 d-flex flex">
      <div class="d-flex flex-column ga-2 w-50">
        <v-text-field :label="$t('start-date')" density="compact" variant="outlined" hide-details="auto" type="date"
          v-model="localForm.startDate" :rules="[(v) => !!v || $t('required-field')]" />
        <v-text-field :label="$t('end-date')" density="compact" variant="outlined" hide-details="auto" type="date"
          v-model="localForm.endDate" :disabled="localForm.isMonthlyPlan" />
      </div>
      <v-checkbox hide-details density="compact" v-model="localForm.isMonthlyPlan" class="h-50">
        <template v-slot:label>
          {{ $t('recurrent') }}
          <v-tooltip location="bottom">
            <template v-slot:activator="{ props }">
              <HelpCircle :size="16" class="ml-1" v-bind="props" color="blue">
              </HelpCircle>
            </template>
            {{ $t('recurrent-help') }}
          </v-tooltip>
        </template>
      </v-checkbox>
    </div>
    <v-select :label="$t('modality')" density="compact" variant="outlined" hide-details="auto"
      v-model="localForm.modality" :items="modalitys" :rules="[it => !!it || $t('required-field')]" :no-data-text="$t('no-data')">
      <template #append-item>
        <div class="pa-2 d-flex align-center justify-space-between">
          <span>{{$t('add-new-item', {item: $t('modality')})}}</span>
          <v-btn :icon="Plus" :size="32" color="primary" rounded @click="openModalAddModality"/>
        </div>
      </template>
    </v-select>
    <v-textarea :label="$t('observation')" density="compact" variant="outlined" hide-details="auto" counter
      v-model="localForm.observation" />
  </v-col>
  <v-dialog v-model="isOpenModalAddModality" width="600px" >
    <v-card>
      <v-form class="pa-2" ref="newModalityForm">
        <v-card variant="outlined">
          <div class="pa-3 text-on-background d-flex flex-column ga-2">
            <ModalityForm :formState="localForm.newModality"/>
          </div>
        </v-card>
      </v-form>
      <v-card-actions>
        <v-spacer />
        <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="closeModalAddModality" />
        <v-btn color="primary" variant="tonal" :text="$t('save')" @click="onSubmintModality"/>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import { HelpCircle, Plus } from "lucide-vue-next"
import { onMounted } from "vue";
import { defineProps, computed, inject, reactive, ref } from "vue"
import Domain from "@/composables/domain/Domain"
import { onSubmit as localOnSubmit } from "@/components/BaseModluleWithLising"
import { z } from "zod"
import ModalityForm from "@/components/workouts/forms/ModalityForm.vue"
import { VForm } from "vuetify/components"
const domain = inject("domain") as Domain;
const props = defineProps(["form"])
const localForm = computed(() => props.form)
const modalitys =reactive<{ title: string, value: string, }[]>([])
const isOpenModalAddModality = ref(false)
const newModalityForm = ref<VForm | null>(null)
onMounted(() => {
  localForm.value.newModality = {};
  localForm.value.isMonthlyPlan = true;
  localForm.value.startDate = new Date().toISOString().substring(0, 10);
  domain.modalities.getAll(list => {
    const modalitiesDomain = list.map(it => ({
      title:it.title,
      value: it.id!!
    }));
    modalitys.splice(0, modalitys.length, ...modalitiesDomain)
  })
})
function openModalAddModality() {
  isOpenModalAddModality.value = true
}
function closeModalAddModality() {
  isOpenModalAddModality.value = false
}
async function onSubmintModality() {
  if (!newModalityForm.value) return;
  const { valid } = await newModalityForm.value.validate()
  if (valid) {
    localOnSubmit(
      domain.modalities,
      z.object({
        title: z.string().min(5),
        value: z.string().transform(it => parseInt(it.replace(/\D/g, '') || "0")),
        description: z.string().default(""),
        modalityPayment: z.enum(["unique-payment", "monthly", "weekly", "biweekly"]),
        active: z.boolean().default(true),
      }),
      localForm.value.newModality || {},
      (it) => {
        const m = it as {title: string, id: string}
        localForm.value.modality = m.id
        modalitys.push({
          title: m.title,
          value: m.id
        })
        closeModalAddModality()
      }
    )
  }
}
</script>

<style></style>
