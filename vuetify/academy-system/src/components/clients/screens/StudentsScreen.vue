<template>
  <v-col class="pa-0 h-100">
    <student-header />
    <v-card variant="outlined" color="surface" class="h-100">
      <v-data-table-virtual :items="clients" :headers="headers" class="bg-background" >
        <template v-slot:[`item.avatar`]="{value}">
          <v-avatar :size="40" color="rgb(var(--v-theme-surface))" class="mr-2">
            <v-img v-if="value" :src="value" />
            <Image v-else />
          </v-avatar>
        </template>
        <template v-slot:[`item.chips`]="{value}">
          <v-row class="ga-1 justify-center">
            <v-chip v-for="chip in value" :key="chip"
              :class="chip.count === 0 && 'pa-1'"
              :color="getChipColor(chip.type)" 
              :prepend-icon="chip.count > 0 && getChipIcon(chip.type)" 
              density="compact" label> 
              <span v-if="chip.count > 0">{{chip.count}}</span>
              <v-icon :icon="getChipIcon(chip.type)" v-else/>
            </v-chip>
          </v-row>
        </template>
        <template v-slot:[`item.contact`]="{value}">
          <v-row class="d-flex ga-1 justify-end px-0">
            <v-chip 
              @click="copy(contact.content); snackbar = true;"
              v-for="contact in value" 
              :key="contact" 
              color="green"
              :prepend-icon="Copy">
              {{contact.content.replace(/(\d{2})(\d{1})(\d{4})(\d{4})/, '($1) $2 $3-$4')}}
              <template v-slot:append>
                <v-btn icon variant="text" class="v-icon--end" size="24">
                  <v-icon :icon="contact.type === 'whatsapp' ? MessageCircle : Phone" :size="16" @click.stop="redirect(contact.content)"/>
                  <v-snackbar v-model="snackbar" :timeout="2000">
                    {{$t('copied')}} 
                  </v-snackbar>
                </v-btn>
              </template>
            </v-chip>
          </v-row>
        </template>
        <template v-slot:[`item.createat`]="{value}">
          {{$d(value, 'short', 'pt-BR')}}
        </template>
        <template v-slot:[`item.age`]="{value}">
          {{$t('age', value, { count: value})}}
        </template>
      </v-data-table-virtual>
    </v-card>
  </v-col>
</template>

<script setup lang="ts">
import StudentHeader from "./components/StudentHeader.vue"
import { reactive, ref } from "vue"
import { Copy, BookmarkX, BookmarkCheck, Cake, UserRoundX, Phone, MessageCircle } from "lucide-vue-next"
import { useI18n } from 'vue-i18n'
import { useClipboard } from "@vueuse/core"

const snackbar = ref(false)
const { t } = useI18n()
const { copy } = useClipboard()
const headers = reactive([
  {title: t('photo'), align: "start", key: "avatar", sortable: false},
  {title: t("name"), align: "center", key: "name"},
  {title: t("create-at"), align: "center", key: "createat"},
  {title: t("age"), align: "center", key: "age"},
  {title: t("e-mail"), align: "start", key: "email", sortable: false, minWidth: "200px"},
  {title: t("status"), align: "center", key: "chips", sortable: false},
  {title: t("contact"), align: "end", key: "contact", sortable: false, maxWidth: "200px"},
])
type Chip = {
  type: "debting" | "debted" | "createat" | "absent";
  count: number;
}
type Contact = {
  type: "whatsapp" | "phone";
  content: string;
}
type ItemTable = {
  avatar: string;
  name: string;
  createat: Date;
  age: number;
  email: string;
  chips: Chip[];
  contact: Contact[];
}
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
] as ItemTable[])
function getChipIcon(type: "debting" | "debted" | "createat" | "absent") {
  if(type === 'debting')
    return BookmarkX
  else if(type === 'debted')
    return BookmarkCheck
  else if(type === 'createat')
    return Cake
  else
    return UserRoundX
}
function getChipColor(type: "debting" | "debted" | "birthday" | "absent") {
  if(type === 'debting')
    return "red" 
  else if(type === 'debted')
    return "green"
  else if(type === 'birthday')
    return "orange" 
  else if(type === 'absent')
    return "teal" 
  else return ""
}
function redirect(number: string) {
  window.open(t('whatsapp-url',{number: number}), '_blanc')
}
</script>

<style>
</style>
