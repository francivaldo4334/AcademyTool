import { createApp } from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import i18n from "./i18n";
import { createPinia } from "pinia";
import LocalBaseAdapter from "./composables/data/LocalBaseAdapter";
import Domain from "./composables/domain/Domain";
import { vMaska } from "maska/vue";

const domain = new Domain(new LocalBaseAdapter());
loadFonts();
createApp(App)
	.directive("mask", vMaska)
	.provide("domain", domain)
	.use(createPinia())
	.use(i18n)
	.use(vuetify)
	.mount("#app");
