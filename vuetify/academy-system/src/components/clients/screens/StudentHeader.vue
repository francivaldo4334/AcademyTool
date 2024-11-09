<template>
  <v-row class="ma-0 fill-width align-center pb-4">
    <v-text-field v-model="inputSearch" :prepend-inner-icon="iconSearch" :label="$t('search')" variant="outlined" hide-details single-line density="compact" max-width="240"/>
    <v-btn class="ml-2 height-40 ma-0"><span style="color: rgb(var(--v-theme-background));">{{$t('search')}}</span></v-btn>
    <v-spacer/>
    <filter-selection :list="filters"/>
    <v-btn icon :size="40" class="ml-2" rounded>
      <user-round-plus/>
      <v-tooltip activator="parent" location="bottom">
        {{$t('add-new-student')}}
      </v-tooltip>
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
      filters: [
        { icon: BookmarkX, tip: 'debtors' },
        { icon: BookmarkCheck, tip: 'debited' },
        { icon: Cake, tip: 'birthdays' },
        { icon: UserRoundX, tip: 'absent' },
      ]
    }
  }
}
</script>

<style>
</style>
