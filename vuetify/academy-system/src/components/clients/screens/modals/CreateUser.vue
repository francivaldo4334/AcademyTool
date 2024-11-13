<template>
  <v-dialog v-model="state.isOpenCreateModal" width="600px">

    <v-card>
      <v-card-title class="text-h6 font-weight-regular justify-space-between d-flex">
        <span>{{ $t(seasons[step]) }}</span>
        <v-item-group v-model="step">
          <v-item v-for="(it, id) in seasons" :key="it" v-slot="{ isSelected, toggle }" :value="id">
            <v-btn icon class="btn-record" @click="toggle" variant="text" size="32">
              <DotIcon v-if="!isSelected" color="rgb(var(--v-theme-on-surface))" />
              <CircleDot v-else color="rgb(var(--v-theme-on-surface))" />
            </v-btn>
          </v-item>
        </v-item-group>
      </v-card-title>
      <v-card-tex>
        <v-window v-model="step">
          <v-window-item :value="0">
            <StudentForm class="fill-height" />
          </v-window-item>
          <v-window-item :value="1">
            <StudentForm class="fill-height" />
          </v-window-item>
          <v-window-item :value="2">
            <StudentForm class="fill-height" />
          </v-window-item>
        </v-window>
      </v-card-tex>
      <v-divider />
      <v-card-actions>
        <v-btn v-if="step > 0" variant="plain" :text="$t('to-back')" :prepend-icon="Undo" @click="step--"></v-btn>
        <v-spacer />
        <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="state.closeCreateModal"></v-btn>
        <v-btn v-if="step > 1" color="primary" variant="tonal" :text="$t('save')"
          @click="state.closeCreateModal"></v-btn>
        <v-btn v-else color="primary" variant="tonal" :text="$t('next')" @click="step++"></v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import { useClientsStore } from "@/stores/ClientsStore"
import { Undo, DotIcon, CircleDot } from "lucide-vue-next"
import { ref } from "vue"
import StudentForm from "@/components/clients/screens/modals/forms/CreateClient.vue"

const state = useClientsStore()
const seasons = {
  0: 'student-data',
  1: 'address',
  2: 'register',
}
const step = ref(0)
</script>


<style scoped>
.btn-record {
  background: rgb(var(--v-theme-surface)) !important;
}
</style>
