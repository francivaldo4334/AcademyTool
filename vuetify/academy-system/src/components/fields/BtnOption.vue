<template>
  <v-btn icon :size="40" :color="(isSelected) ? 'primary' : option.isHover ? 'secondary' : 'transparent'" class="ma-2" elevation="0">
    <v-icon color="background" :icon="option.icon" />
    <v-tooltip activator="parent" location="end">{{ $t(option.tag, 2) }}</v-tooltip>
  </v-btn>
</template>

<script lang="ts">
import { defineComponent, FunctionalComponent } from "vue";

type TypeOption = {
  icon: FunctionalComponent;
  tag: string;
  isHover: boolean;
  id: number;
};

export default defineComponent({
  props: {
    option: {
      type: Object as () => TypeOption,
      required: true,
    },
    isSelected: {
      type: Boolean,
      required: true,
    },
  },
});
</script>

<style></style>
