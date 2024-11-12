import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import i18n from './i18n'
import { Database } from './data/Database'
import { createPinia } from "pinia"

loadFonts()

createApp(App)
  .use(createPinia())
  .use(i18n)
  .provide("$db", new Database())
  .use(vuetify)
  .mount('#app')
