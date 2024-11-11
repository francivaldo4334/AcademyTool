<template>
  <v-row class="ma-0 fill-width align-center pb-4">
    <v-text-field v-model="inputSearch" :prepend-inner-icon="iconSearch" :label="$t('search')" variant="outlined"
      hide-details single-line density="compact" max-width="240" />
    <v-btn class="ml-2 height-40 ma-0"><span style="color: rgb(var(--v-theme-background));">{{ $t('search')
        }}</span></v-btn>
    <v-spacer />
    <v-select label="Itens por pagina" density="compact" variant="outlined" :items="['5', '10', '15']"
      class="mr-4"></v-select>
    <filter-selection :list="filters" />
    <create-user />
    <v-btn icon :size="40" class="ml-2" @click="state.openCreateModal" rounded>
      <user-round-plus />
      <v-tooltip activator="parent" location="bottom">
        {{ $t('add-new-student') }}
      </v-tooltip>
    </v-btn>
  </v-row>
</template>

<script lang="ts">
import { Search, BookmarkX, BookmarkCheck, Cake, UserRoundX, UserRoundPlus } from "lucide-vue-next"
import FilterSelection from "@/components/fields/FilterSelection.vue"
import { useClientsStore } from "@/stores/ClientsStore"
import CreateUser from "./modals/CreateUser.vue"
export default {
  components: { UserRoundPlus, FilterSelection, CreateUser },
  data() {
    return {
      iconSearch: Search,
      inputSearch: "",
      filters: [
        { icon: BookmarkX, tip: 'debtors', checked: false },
        { icon: BookmarkCheck, tip: 'debited', checked: false },
        { icon: Cake, tip: 'birthdays', checked: false },
        { icon: UserRoundX, tip: 'absent', checked: false },
      ],
      state: useClientsStore()
    }
  }
}
</script>

<style scoped>
.v-select {
  transform: translateY(11px);
  max-width: 180px;
}
</style>
