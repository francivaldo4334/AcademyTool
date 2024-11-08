<template>
  <v-app theme="light">
    <v-main>
      <menu-mdules />
    </v-main>
  </v-app>
</template>

<script>
import MenuMdules from "./components/MenuMdules.vue"
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
.v-btn--icon {
  background: rgb(var(--v-theme-primary));
}
.v-btn__content {
  color: rgb(var(--v-theme-background))
}

</style>
