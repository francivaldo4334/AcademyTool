<template>
  <div class="overflow-hidden v-btn--variant-elevated" style="border-radius: 4px; height: 36px;">
    <v-btn v-for="(it, id) in list" :key="id" :class="getBtnColor(it)" class="rounded-0" size="36" icon variant="text"
      @click="toggle(it)">
      <component v-bind="props" :is="it.icon" />
      <v-tooltip activator="parent" location="bottom">
        {{ $t(it.tip) }}
      </v-tooltip>
    </v-btn>
  </div>
</template>

<script>
export default {
  data() {
    return {
      toggle(it) {
        it.checked = !it.checked
      },
      getBtnColor(it) {
        if (it.checked) {
          return "check-btn-selected"
        }
        return ""
      }
    }
  },
  props: {
    list: {
      type: Array,
      required: true,
    }
  }
}
</script>

<style scoped>
.v-btn--icon {
  background: rgb(var(--v-theme-surface)) !important;
}

.lucide {
  color: rgb(var(--v-theme-on-surface)) !important;
}

.check-btn-selected {
  background: rgb(var(--v-theme-primary)) !important;
}

.check-btn-selected .lucide {
  color: rgb(var(--v-theme-background)) !important;

}
</style>
