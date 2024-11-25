import { createApp } from "vue";
import App from "./App.vue";
import vuetify from "./core/plugins/vuetify";
import { loadFonts } from "./core/plugins/webfontloader";
import i18n from "./core/plugins/i18n";
import { createPinia } from "pinia";
import LocalBaseAdapter from "./core/composables/data/LocalBaseAdapter";
import Domain from "./core/composables/domain/Domain";
import { vMaska } from "maska/vue";
// @ts-ignore
import { VMoney } from "v-money";

const domain = new Domain(new LocalBaseAdapter());
loadFonts();
createApp(App)
	.directive("mask", vMaska)
	.directive("money", VMoney)
	.provide("domain", domain)
	.use(createPinia())
	.use(i18n)
	.use(vuetify)
	.mount("#app");
