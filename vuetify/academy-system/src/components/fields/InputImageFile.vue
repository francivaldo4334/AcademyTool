<template>
  <div>
    <div :style="btnUploadStyle" class="bg-primary rounded-xl position-absolute">
      <v-file-input hide-input :prepend-icon="MUpload" name="avatar" accept="image/png, image/jpeg"
        class="w-100 h-100 d-flex align-center">
      </v-file-input>
    </div>
      <v-avatar :size="96" color="surface-light" rounded>
        <v-img v-if="urlCompanyPhoto" :src="urlCompanyPhoto" />
        <Image v-else color="rgb(var(--v-theme-on-surface))" />
      </v-avatar>
  </div>
</template>

<script lang="ts" setup>
import { Upload, Image } from "lucide-vue-next"
import { h } from "vue"
const MUpload = h(Upload, {
  size: 20,
  color: "background"
})
const btnUploadStyle = {
  width: '32px',
  height: '32px', 
  "z-index": 1,
  top: '-8px',
  right: '-8px'
}
</script>

<style>
</style>
