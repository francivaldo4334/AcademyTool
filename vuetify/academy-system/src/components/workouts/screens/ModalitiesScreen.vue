<template>
  <ModalityHeader class="top-0" />
  <v-card variant="outlined" color="surface">
    <StudentTable />
  </v-card>
</template>
<script setup lang="ts">
import ModalityHeader from './components/ModalityHeader.vue'
import StudentTable from './components/ModalityTable.vue'
</script>
