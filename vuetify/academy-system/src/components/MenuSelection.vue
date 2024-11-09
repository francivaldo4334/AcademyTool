<template>
    <v-bottom-navigation class="mb-4" v-model="optionSelected" bg-color="rgb(var(--v-theme-background))" elevation="0"
      color="rgb(var(--v-theme-primary))" height="40">
      <v-btn v-for="(it, id) in list" :key="id">{{it}}</v-btn>
    </v-bottom-navigation>
    <slot :option="optionSelected"></slot>
</template>

<script>
export default {
  data(){
    return{
      optionSelected: 0
    }
  },
  props: {
    list: {
      type: Array,
      required: true
    }
  }
}
</script>

<style></style>
