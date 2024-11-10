<template>
  <v-dialog v-model="isOpenModalCreate" width="auto">
    <v-card min-widht="400" min-height="400">
    </v-card>
  </v-dialog>
</template>

<script>
import { useClientStore } from "@/components/clients/ClientsState"
export default {
  setup() {
    const useState = useClientStore()
    return {
      isOpenModalCreate: useState.isOpenModalCreate
    }
  }
}
</script>

<style>

</style>
