<template>
  <v-navigation-drawer color="rgb(var(--v-theme-on-background))" :rail="true" permanent rail-width="56" class="d-flex flex-column">
    <v-col class="fill-height d-flex flex-column align-center justify-center pa-0" style="gap: 16px;">
      <BtnSelection v-btn v-for="it in options" :key="it.id" :option="it" :isSelected="selected === it.tag" onClick="() => {selected = it.tag}"/>
    </v-col>
    <v-btn icon :size="40" @click="selected = 'settings'" class="position-absolute bottom-0">
      <Settings />
      <v-tooltip activator="parent" location="end">{{$t('settings')}}</v-tooltip>
    </v-btn>
  </v-navigation-drawer>
  <v-col class="pa-4 fill-height">
    <app-bar />
    <v-col lg="8" offset-lg="2">
      <clients-screen v-if="selected === 'students'" />
      <metrics-screen v-else-if="selected === 'metrics'" />
      <financial-screen v-else-if="selected === 'financial'" />
      <equipments-screen v-else-if="selected === 'equipments'" />
    </v-col>
  </v-col>
</template>

<script setup lang="ts">
import { Settings, Users, ChartNoAxesCombined, Dumbbell, HandCoins } from "lucide-vue-next";
import ClientsScreen from "./clients/MainScreen.vue"
import MetricsScreen from "./metrics/MainScreen.vue"
import FinancialScreen from "./financial/MainScreen.vue"
import EquipmentsScreen from "./equipments/MainScreen.vue"
import AppBar from "./AppBar.vue"
import { FunctionalComponent } from "vue"
import { ref } from "vue"
import BtnSelection from "./fields/BtnSelection.vue"
const selected = ref('students')
type Option = {
  icon: FunctionalComponent,
  tag: string,
  id: number
}
const options: Option[] = [
  {
    icon: Users,
    tag: 'students',
    id: 0
  },
  {
    icon: ChartNoAxesCombined,
    tag: 'metrics',
    id: 1
  },
  {
    icon: HandCoins,
    tag: 'financial',
    id: 2
  },
  {
    icon: Dumbbell,
    tag: 'equipments',
    id: 3
  }
]
</script>
<style>
</style>
