<template>
  <div>
    <div :style="btnUploadStyle" class="bg-primary rounded-xl position-absolute">
      <v-btn v-if="localFile" icon class="w-100 h-100 d-flex align-center" color="primary">
        <Trash2 size="20" class="opacity-50" @click="localFile = null" />
      </v-btn>
      <v-file-input v-else hide-input :prepend-icon="MUpload" name="avatar" accept="image/png, image/jpeg"
        class="w-100 h-100 d-flex align-center" v-model="localFile">
      </v-file-input>
    </div>
    <v-avatar :size="96" color="surface-light" rounded>
      <v-img v-if="imageUrl" :src="imageUrl" />
      <Image v-else color="rgb(var(--v-theme-on-surface))" />
    </v-avatar>
  </div>
</template>

<script lang="ts" setup>
import { Upload, Image, Trash2 } from "lucide-vue-next"
import { h, defineProps, ref, computed } from "vue"
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
const props = defineProps({
  onLoadFile: {
    type: Function,
    required: true
  }
})
const file = ref<File | null>(null)
const localFile = computed({
  get() {
    return file.value
  },
  set(value: File) {
    file.value = value
    props.onLoadFile(file.value)
  }
})
const imageUrl = computed(() => localFile.value ? URL.createObjectURL(localFile.value) : null)
</script>

<style></style>
