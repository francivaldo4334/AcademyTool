<template>
  <student-header class="top-0"/>
  <v-card variant="outlined" color="surface" >
    <StudentTable :clients="clients"/>
  </v-card>
</template>

<script setup lang="ts">
import StudentHeader from "./components/StudentHeader.vue"
import StudentTable from "./components/StudentTable.vue"
import { reactive, onMounted, inject } from "vue"
import Domain from "@/composables/domain/Domain"
const clients = reactive([] as any[])
onMounted(() => {
  const domain = inject('$domain') as Domain
  if (!domain) {
    console.error('Domain not provided via inject!');
    return
  }
  domain.users.geAll((it: any[]) => {
    clients.splice(0, clients.length, ...it)
  })
})
//const clients = reactive([
//  {
//    avatar: "https://github.com/francivaldo4334.png",
//    name: "name",
//    createat: new Date("2002-01-29"), 
//    age: 20,
//    email: "teste@gmail.com",
//    chips: [
//      {
//        type: "debted",
//        count: 3
//      },
//      {
//        type: "debting",
//        count: 0
//      },
//      {
//        type: "absent",
//        count: 20
//      },
//      {
//        type: "birthday",
//        count: 0
//      }
//    ],
//    contact: [
//      {
//        type: 'whatsapp',
//        content: "86981266564",
//      },
//    ]
//  }
//])
</script>

<style>
</style>
