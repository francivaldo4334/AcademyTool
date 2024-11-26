<template>
  <v-select :label="$t('modality')" density="compact" variant="outlined" hide-details="auto"
    v-model="localForm.modality" :items="modalitys" :rules="[it => !!it || $t('required-field')]" :no-data-text="$t('no-data')">
    <template #append-item>
      <div class="pa-2 d-flex align-center justify-space-between">
        <span>{{$t('add-new-item', {item: $t('modality')})}}</span>
        <v-btn :icon="Plus" :size="32" color="primary" @click="openModalAddModality"/>
      </div>
    </template>
  </v-select>

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
<script setup lang="ts">
import { computed, reactive, ref, inject, onMounted, defineProps } from 'vue'
import { VForm } from "vuetify/components"
import { onSubmit as localOnSubmit } from "@/core/components/BaseModluleWithLising"
import Domain from "@/core/composables/domain/Domain"
import ModalityRepository from "@/workouts/composables/domain/repositories/ModalityRepository"
import ModalityForm from "@/workouts/components/forms/ModalityForm.vue"
import { formModalityScheme } from "../WorkoutsScreen"
import { Plus } from "lucide-vue-next"
const props = defineProps(["form"])
const localForm = computed(() => props.form)
const modalitys = reactive<{ title: string, value: string, }[]>([])
const isOpenModalAddModality = ref(false)
const newModalityForm = ref<VForm | null>(null)
const domain = inject("domain") as Domain
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
      domain.getRepository(ModalityRepository),
      formModalityScheme,
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
onMounted(() => {
  domain.getRepository(ModalityRepository).getAll(list => {
    const modalitiesDomain = list.map(it => ({
      title: it.title,
      value: it.id!!
    }));
    modalitys.splice(0, modalitys.length, ...modalitiesDomain)
  })
})
</script>
