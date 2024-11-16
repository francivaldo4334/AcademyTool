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
    <v-tabs-window v-model="screen" class="position-absolute bottom-0 left-0 right-0 w-100 pl-14 pb-2" >
      <v-tabs-window-item value="student">
        <v-pagination
          v-model="page"
          :length="4"
          rounded="circle"
          active-color="primary"
          variant="flat"
        ></v-pagination>
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
