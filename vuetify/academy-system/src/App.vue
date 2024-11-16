<template>
  <v-app theme="light">
    <v-main>
      <menu-mdules />
    </v-main>
  </v-app>
</template>

<script>
import MenuMdules from "./components/MenuSideModules.vue"
export default {
  name: 'App',
  components: {
    MenuMdules,
  },

  data: () => ({
    //
  }),
}
</script>
<style>
</style>
