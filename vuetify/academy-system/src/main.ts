import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import i18n from './i18n'
import { createPinia } from "pinia"
import LocalBaseAdapter from "./composables/data/LocalBaseAdapter"

loadFonts()

createApp(App)
  .use(createPinia())
  .use(i18n)
  .provide("$db", new LocalBaseAdapter())
  .use(vuetify)
  .mount('#app')
