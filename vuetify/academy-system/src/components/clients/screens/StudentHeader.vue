<template>
  <v-row class="ma-0 fill-width align-center pb-4">
    <v-text-field v-model="inputSearch" :prepend-inner-icon="iconSearch" label="Pesquisar" variant="outlined" hide-details single-line density="compact" max-width="240"/>
    <v-btn class="ml-2 height-40 ma-0"><span style="color: rgb(var(--v-theme-background));">Pesquisar</span></v-btn>
    <v-spacer/>
    <filter-selection :list="filters"/>
    <v-btn icon :size="40" class="ml-2" rounded>
      <user-round-plus/>
    </v-btn>
  </v-row>
</template>

<script>
import { Search, BookmarkX, BookmarkCheck, Cake, UserRoundX, UserRoundPlus } from "lucide-vue-next"
import FilterSelection from "@/components/fields/FilterSelection.vue"
export default {
  components: { UserRoundPlus, FilterSelection },
  data(){
    return{
      iconSearch: Search,
      inputSearch: "",
      filters: [BookmarkX, BookmarkCheck, Cake, UserRoundX]
    }
  }
}
</script>

<style>
</style>
