<template>
  <v-navigation-drawer color="rgb(var(--v-theme-on-background))" :rail="true" permanent rail-width="56px"
    class="d-flex flex-column">
    <v-col class="fill-height d-flex flex-column align-center justify-center pa-0 gy-4">
      <BtnOption v-for="option in options" :option="option" :key="option.id" :isSelected="selected === option.id"
        @click="selected = option.id" @mouseover="option.isHover = true" @mouseleave="option.isHover = false">
      </BtnOption>
    </v-col>
    <BtnOption :option="lastOption" :key="lastOption.id" :isSelected="selected === lastOption.id"
      @click="selected = lastOption.tag" @mouseover="lastOption.isHover = true" @mouseleave="lastOption.isHover = false"
      class="position-absolute bottom-0">
    </BtnOption>
  </v-navigation-drawer>
  <v-col class="px-0 py-0 pl-16 pr-2">
    <app-bar />
    <clients-screen v-if="selected === 0" />
    <metrics-screen v-else-if="selected === 1" />
    <financial-screen v-else-if="selected === 2" />
    <equipments-screen v-else-if="selected === 3" />
    <equipments-screen v-else-if="selected === 4" />
    <workouts-screen v-else-if="selected === 5" />
  </v-col>
</template>

<script setup lang="ts">
import { Settings, Users, ChartNoAxesCombined, Dumbbell, HandCoins, ClipboardPenLine } from "lucide-vue-next";
import ClientsScreen from "@/clients/components/MainScreen.vue"
import WorkoutsScreen from "@/workouts/components/WorkoutsScreen.vue"
import AppBar from "./AppBar.vue"
import { FunctionalComponent } from "vue"
import { ref, reactive } from "vue"
import BtnOption from "@/core/components/fields/BtnOption.vue"
const selected = ref(0)
type Option = {
  icon: FunctionalComponent,
  tag: string,
  isHover: boolean,
  id: number
}
const lastOption = ref({
  icon: Settings,
  tag: "setting",
  isHover: false,
  id: 4,
})
const options: Option[] = reactive([
  {
    icon: Users,
    tag: 'student',
    isHover: false,
    id: 0
  },
  {
    icon: ChartNoAxesCombined,
    tag: 'metric',
    isHover: false,
    id: 1
  },
  {
    icon: HandCoins,
    tag: 'financial',
    isHover: false,
    id: 2
  },
  {
    icon: Dumbbell,
    tag: 'equipment',
    isHover: false,
    id: 3
  },
  {
    icon: ClipboardPenLine,
    tag: 'workout',
    isHover: false,
    id: 5
  }
])
</script>
<style></style>
