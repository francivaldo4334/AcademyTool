<template>
  <v-navigation-drawer :rail="true" permanent rail-width="56" class="d-flex flex-column">
    <v-col class="fill-height d-flex flex-column align-center justify-center pa-0 main-options">
      <v-btn icon :size="40" :class="getClass('students')" @click="setSelected('students')">
        <users />
        <v-tooltip activator="parent" location="end">{{$t('clients')}}</v-tooltip>
      </v-btn>
      <v-btn icon :size="40" :class="getClass('metrics')" @click="setSelected('metrics')">
        <chart-no-axes-combined />
        <v-tooltip activator="parent" location="end">{{$t('metrics')}}</v-tooltip>
      </v-btn>
      <v-btn icon :size="40" :class="getClass('financial')" @click="setSelected('financial')">
        <hand-coins />
        <v-tooltip activator="parent" location="end">{{$t('financial')}}</v-tooltip>
      </v-btn>
      <v-btn icon :size="40" :class="getClass('equipments')" @click="setSelected('equipments')">
        <dumbbell />
        <v-tooltip activator="parent" location="end">{{$t('equipments')}}</v-tooltip>
      </v-btn>
    </v-col>
    <v-btn icon :size="40" :class="getClass('settings')" @click="setSelected('settings')" class="position-absolute bottom-0">
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

<script>
import { Settings, Users, ChartNoAxesCombined, Dumbbell, HandCoins } from "lucide-vue-next";
import ClientsScreen from "./clients/MainScreen.vue"
import MetricsScreen from "./metrics/MainScreen.vue"
import FinancialScreen from "./financial/MainScreen.vue"
import EquipmentsScreen from "./equipments/MainScreen.vue"
import AppBar from "./AppBar.vue"

export default {
  components: {
    Users,
    ChartNoAxesCombined,
    Dumbbell,
    HandCoins,
    Settings,
    AppBar,
    ClientsScreen,
    MetricsScreen,
    FinancialScreen,
    EquipmentsScreen,
  },
  data() {
    return {
      selected: 'students',
    }
  },
  methods: {
    setSelected(icon) {
      this.selected = icon;
    },
    getClass(icon) {
      return {
        'selected-btn': this.selected === icon
      }
    }
  }
}
</script>
<style scoped>
.v-btn {
  margin: 8px;
}

.v-btn--icon {
  background: rgb(var(--v-theme-on-background)) !important;
}

.selected-btn {
  background: rgb(var(--v-theme-primary)) !important;
  transition: background-color 0.3s ease;
}

.v-btn--icon:hover {
  background: rgb(var(--v-theme-surface));
}

.v-navigation-drawer {
  background: rgb(var(--v-theme-on-background));
}
</style>
