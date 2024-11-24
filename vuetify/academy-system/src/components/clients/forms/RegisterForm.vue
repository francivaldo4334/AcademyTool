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
      v-model="localForm.modality" :items="modalitys" />
    <v-textarea :label="$t('observation')" density="compact" variant="outlined" hide-details="auto" counter
      v-model="localForm.observation" />
  </v-col>
</template>

<script lang="ts" setup>
import { HelpCircle } from "lucide-vue-next"
import { onMounted } from "vue";
import { defineProps, computed } from "vue"
const props = defineProps(["form"])
const localForm = computed(() => props.form)
const modalitys = [
  {
    title: "1",
    value: 1,
  },
  {
    title: "2",
    value: 2,
  },
  {
    title: "3",
    value: 3,
  }
]
onMounted(() => {
  localForm.value.isMonthlyPlan = true;
  localForm.value.startDate = new Date().toISOString().substring(0, 10);
})
</script>

<style></style>
