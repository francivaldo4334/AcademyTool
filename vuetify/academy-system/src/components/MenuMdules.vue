<template>
  <v-navigation-drawer :rail="true" permanent rail-width="56">
    <v-col class="d-flex flex-column align-center justify-center h-100 pa-0">
      <v-btn icon :size="40">
        <Users />
      </v-btn>
      <v-btn icon :size="40">
        <ChartNoAxesCombined />
      </v-btn>
      <v-btn icon :size="40">
        <HandCoins />
      </v-btn>
      <v-btn icon :size="40">
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
  }
}
</script>
<style>
.v-btn {
  margin: 8px;
}
</style>
