<template>
  <v-navigation-drawer :rail="true" permanent rail-width="56">
    <v-col class="d-flex flex-column align-center justify-center h-100 pa-0">
      <v-btn icon :size="40" :class="getClass('students')" @click="setSelected('students')">
        <users />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('metrics')" @click="setSelected('metrics')">
        <chart-no-axes-combined />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('financial')" @click="setSelected('financial')">
        <hand-coins />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('equipments')" @click="setSelected('equipments')">
        <dumbbell />
      </v-btn>
    </v-col>
  </v-navigation-drawer>
  <v-layout>
    <v-col>
      <v-row class="pa-4">
        <v-img rounded :max-width="40" aspect-ratio="1/1" cover  :src="urlCompanyPhoto" class="w-40 h-40 bg-red">
          <Image v-if="!urlCompanyPhoto" />
        </v-img>
      </v-row>
      <v-col>
        <students-screen v-if="selected === 'students'"/>
        <metrics-screen v-if="selected === 'metrics'"/>
        <financial-screen v-if="selected === 'financial'"/>
        <equipments-screen v-if="selected === 'equipments'"/>
      </v-col>
    </v-col>
  </v-layout>
</template>

<script>
import { Users, ChartNoAxesCombined, Dumbbell, HandCoins, Image } from "lucide-vue-next";
import StudentsScreen from "./students/MainScreen.vue"
import MetricsScreen from "./metrics/MainScreen.vue"
import FinancialScreen from "./financial/MainScreen.vue"
import EquipmentsScreen from "./equipments/MainScreen.vue"
 
export default {
  components: {
    Users,
    ChartNoAxesCombined,
    Dumbbell,
    HandCoins,
    Image,
    StudentsScreen,
    MetricsScreen,
    FinancialScreen,
    EquipmentsScreen,
  },
  data(){
    return{
      selected: 'students',
      // urlCompanyPhoto: "https://www.github.com/francivaldo4334.png",
      urlCompanyPhoto: "",
    }
  },
  methods:{
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

.selected-btn {
  background: rgb(var(--v-theme-primary))!important;
  transition: background-color 0.3s ease; 
}

.v-btn--icon {
  background: rgb(var(--v-theme-on-background));
}

.v-btn--icon:hover {
  background: rgb(var(--v-theme-surface));
}

.v-navigation-drawer {
  background: rgb(var(--v-theme-on-background));
}
</style>
