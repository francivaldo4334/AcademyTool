<template>
  <student-header class="top-0"/>
  <v-card variant="outlined" color="surface" >
    <StudentTable :clients="clients"/>
  </v-card>
  <v-pagination
    v-model="page"
    :length="4"
    rounded="circle"
  ></v-pagination>
</template>

<script setup lang="ts">
import StudentHeader from "./components/StudentHeader.vue"
import StudentTable from "./components/StudentTable.vue"
import { reactive, ref } from "vue"
const page = ref(1)
const clients = reactive([
  {
    avatar: "https://github.com/francivaldo4334.png",
    name: "name",
    createat: new Date("2002-01-29"), 
    age: 20,
    email: "teste@gmail.com",
    chips: [
      {
        type: "debted",
        count: 3
      },
      {
        type: "debting",
        count: 0
      },
      {
        type: "absent",
        count: 20
      },
      {
        type: "birthday",
        count: 0
      }
    ],
    contact: [
      {
        type: 'whatsapp',
        content: "86981266564",
      },
    ]
  }
])
</script>

<style>
</style>
