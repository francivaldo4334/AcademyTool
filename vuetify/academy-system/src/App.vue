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
.v-btn--icon,
.v-btn--variant-elevated {
  background: rgb(var(--v-theme-primary)) !important;
}

.v-btn--icon>.v-btn__content {
  color: rgb(var(--v-theme-background))
}
</style>
