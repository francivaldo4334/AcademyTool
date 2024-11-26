<template>
  <v-app theme="light">
    <v-main>
      <MinApp/>
    </v-main>
  </v-app>
</template>

<script>
import MinApp from "@/app/MainApp.vue"
export default {
  name: 'App',
  components: {
    MinApp,
  },

  data: () => ({
    //
  }),
}
</script>
<style>
</style>
