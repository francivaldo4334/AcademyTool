<template>
  <div class="w-100 h-100">
    <v-col offset="2" cols="8">
      <p class="text-h5 mb-4">{{ $t(title, 2) }}</p>
      <v-tabs v-model="menuSelected" color="primary" class="mb-4">
        <v-tab v-for="opt in menuOptions" :key="opt.key" :value="opt.key">{{ $t(opt.name, 2) }}</v-tab>
      </v-tabs>
      <v-divider/>
      <slot name="filters"/>
    </v-col>
  </div>
</template>
<script setup lang="ts">
import { defineProps, ref } from "vue"
import { MenuItem } from "./BaseModluleWithLisingTypes"
const menuSelected = ref(0)
export type FilterItem<M, I> = Record<keyof M, (list:I[]) => I[]>;
defineProps({
  title: {
    type: String,
    default: "TITLE"
  },
  menuOptions: {
    type: Array as () => MenuItem[],
    default: () => [
      { key: 0, name: "ITEM_1" },
      { key: 1, name: "ITEM_2" },
      { key: 2, name: "ITEM_3" },
    ],
  },
  filters: {
    type: Array as <M, I>() => FilterItem<M, I>[],
    default: () => {
      ITEM_1: (list: any): any => {
        return list
      }
    }
  }
})
</script>
