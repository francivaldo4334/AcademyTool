<template>
  <!-- <v-file-input hide-input :prepend-icon="Upload" class="d-flex flex-column align-end custom-input-file" max-width="96"> -->
  <!--   <template v-slot:prepend> -->
  <!--     <v-tooltip activator="parent" :text="$t('image-upload')" location="bottom" /> -->
  <!--   </template> -->
  <!--   <template v-slot:append> -->
  <!--     <v-avatar :size="96" color="surface-light" rounded> -->
  <!--       <v-img v-if="urlCompanyPhoto" :src="urlCompanyPhoto" /> -->
  <!--       <Image v-else color="rgb(var(--v-theme-on-surface))" /> -->
  <!--     </v-avatar> -->
  <!--   </template> -->
  <!-- </v-file-input> -->
  <div style="width: 40px; height:40px;">
    <v-file-input hide-input :prepend-icon="Upload" name="avatar" accept="image/png, image/jpeg"
      class="aspect-w-1 aspect-h-1">
    </v-file-input>
  </div>
</template>

<script lang="ts" setup>
import { Upload, Image } from "lucide-vue-next"
Upload
Image
</script>

<style></style>
