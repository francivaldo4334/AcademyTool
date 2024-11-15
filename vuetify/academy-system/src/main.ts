import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import i18n from './i18n'
import { Database } from './composables/data/Database'
import { createPinia } from "pinia"
import Repository from './composables/domain/Repository'

loadFonts()

createApp(App)
  .use(createPinia())
  .use(i18n)
  .provide("$domain", new Repository(new Database()))
  .use(vuetify)
  .mount('#app')
