<template>
  <div class="overflow-hidden v-btn--variant-elevated" style="border-radius: 4px; height: 36px;">
    <v-btn v-for="(it,id) in list" :key="id" class="rounded-0" size="36" icon >
        <component :is="it"/>
    </v-btn>
  </div>
</template>

<script>
export default {
  props:{
    list: {
      type: Array,
      required: true,
    }
  }
}
</script>

<style></style>
