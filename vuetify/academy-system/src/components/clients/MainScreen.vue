<template>
  <v-col class="ma-0 pa-0">
    <p class="text-h5 mb-4">{{ $t('clients') }}</p>
    <v-tabs v-model="screen" color="primary">
      <v-tab v-for="it in screens" :key="it" :value="it">{{ $t(it) }}</v-tab>
    </v-tabs>
    <v-tabs-window v-model="screen">
      <v-tabs-window-item value="students">
        <students-screen />
      </v-tabs-window-item>
    </v-tabs-window>
    <!-- <menu-selection :list="[ -->
    <!-- ]"> </menu-selection> -->
    <!-- <template #default="{ option }"> -->
    <!--   <students-screen v-if="option === 0" /> -->
    <!-- </template> -->
  </v-col>
</template>

<script>
import StudentsScreen from "./screens/StudentsScreen.vue"
export default {
  components: {
    StudentsScreen,
  },
  data() {
    return {
      screen: null,
      screens: ['students', 'classes', 'birthdays']
    }
  },
}
</script>

<style>
.v-bottom-navigation {
  bottom: auto !important;
  position: relative !important;
  left: 0 !important;
}

.v-bottom-navigation__content {
  justify-content: start !important;
}
</style>
