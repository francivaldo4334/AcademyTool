<template>
  <v-col class="pa-0">
    <student-header/>
    <v-data-table-virtual>
    </v-data-table-virtual>
  </v-col>
</template>

<script>
import StudentHeader from "./StudentHeader.vue"
export default {
  components: {
    StudentHeader,
  },
  data() {
    return {
      inputSearch: "", 
    }
  },
}
</script>

<style>
</style>
