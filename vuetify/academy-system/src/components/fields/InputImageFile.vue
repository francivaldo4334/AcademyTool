<template>
  <v-file-input hide-input :prepend-icon="Upload" class="d-flex flex-column align-end custom-input-file" max-width="96">
    <template v-slot:prepend>
      <v-tooltip activator="parent" :text="$t('image-upload')" location="bottom" />
    </template>
    <template v-slot:append>
      <v-avatar :size="96" color="surface-light" rounded>
        <v-img v-if="urlCompanyPhoto" :src="urlCompanyPhoto" />
        <Image v-else color="rgb(var(--v-theme-on-surface))" />
      </v-avatar>
    </template>
  </v-file-input>
</template>

<script setup lang="ts">
import { Upload, Image } from "lucide-vue-next"
</script>

<style>
.custom-input-file {
  height: 96px !important;
  overflow: unset;
  transform: translateY(-32px);
}

.custom-input-file>.v-input__prepend {
  margin: 0 !important;
  z-index: 1;
  transform: translate(25%, 75%);
}

.custom-input-file>.v-input__append {
  margin: 0 8px;
  top: 0;
  margin: 0 !important;
}

.custom-input-file>.v-input__prepend>.v-icon {
  opacity: 1 !important;
  background: rgb(var(--v-theme-primary));
  color: rgb(var(--v-theme-background));
  padding: 8px;
  border-radius: 50%;
  width: 32px;
  height: 32px;
}
</style>
