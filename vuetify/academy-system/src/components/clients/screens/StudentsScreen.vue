<template>
  <div class="d-flex flex-column">
    <student-header class="top-0" />
    <v-card variant="outlined" color="surface">
      <StudentTable :clients="state.students" />
    </v-card>
  </div>
</template>

<script setup lang="ts">
import StudentHeader from "./components/StudentHeader.vue"
import StudentTable from "./components/StudentTable.vue"
import { useClientsStore } from "@/stores/ClientsStore.ts"
const state = useClientsStore()

</script>

<style></style>
