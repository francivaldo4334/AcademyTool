<template>
    <p class="text-h5 mb-4">{{ $t('client', 2) }}</p>
    <v-tabs v-model="screen" color="primary">
      <v-tab v-for="it in screens" :key="it" :value="it">{{ $t(it, 2) }}</v-tab>
    </v-tabs>
    <v-tabs-window v-model="screen" >
      <v-tabs-window-item value="student">
        <students-screen />
      </v-tabs-window-item>
    </v-tabs-window>
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
      screens: ['student', 'class', 'birthday']
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
