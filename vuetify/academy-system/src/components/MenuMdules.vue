<template>
  <v-navigation-drawer :rail="true" permanent rail-width="56">
    <v-col class="d-flex flex-column align-center justify-center h-100 pa-0">
      <v-btn icon :size="40" :class="getClass('students')" @click="setSelected('students')">
        <Users />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('metrics')" @click="setSelected('metrics')">
        <ChartNoAxesCombined />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('financial')" @click="setSelected('financial')">
        <HandCoins />
      </v-btn>
      <v-btn icon :size="40" :class="getClass('equipments')" @click="setSelected('equipments')">
        <Dumbbell />
      </v-btn>
    </v-col>
  </v-navigation-drawer>
</template>

<script>
import { Users, ChartNoAxesCombined, Dumbbell, HandCoins } from "lucide-vue-next";
export default {
  components: {
    Users, ChartNoAxesCombined, Dumbbell, HandCoins
  },
  data(){
    return{
      selected: 'students'
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
