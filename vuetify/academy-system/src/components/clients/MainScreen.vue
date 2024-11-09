<template>
  <v-col class="ma-0 pa-0">
    <p class="text-h5 mb-4">Estudantes</p>
    <menu-selection :list="['Alunos', 'Turmas', 'Aniversariantes']">
      <template #default="{ option }">
        <students-screen v-if="option === 0"/>
      </template>
    </menu-selection>
  </v-col>
</template>

<script>
import MenuSelection from "@/components/MenuSelection.vue"
import StudentsScreen from "./screens/StudentsScreen.vue"
export default {
  components:{
    MenuSelection,
    StudentsScreen
  },
}
</script>

<style>
.v-bottom-navigation {
  bottom: auto !important;
  position: relative !important;
  left: 0 !important;
}

.v-bottom-navigation__content {
  justify-content: start !important;
}
</style>
