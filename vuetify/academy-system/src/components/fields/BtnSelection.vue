<template>
      <v-btn icon :size="40" @click="onClick"
             :color="isSelected ? 'primary' : 'transparent'" >
        <v-icon :icon="option.icon"/> 
        <v-tooltip activator="parent" location="end">{{$t('clients')}}</v-tooltip>
      </v-btn>
</template>

<script lang="ts">
import { FunctionalComponent } from "vue"
type Option = {
  icon: FunctionalComponent,
  tag: string,
  id: number
}
export default {
  props: {
    option: {
      type: Object as () =>  Option,
      required: true,
    },
    isSelected: {
      type: Boolean,
      required: true,
    },
  }
}
</script>

<style>
</style>
