import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import i18n from './i18n'
import { createPinia } from "pinia"
import LocalBaseAdapter from "./composables/data/LocalBaseAdapter"
import Domain from './composables/domain/Domain'

loadFonts()

createApp(App)
  .use(createPinia())
  .use(i18n)
  .provide("$domain", new Domain(new LocalBaseAdapter()))
  .use(vuetify)
  .mount('#app')
