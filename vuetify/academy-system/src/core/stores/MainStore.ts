import { defineStore } from "pinia";
import { reactive } from "vue";

export const useMainStore = defineStore("main", () => {
	const modules = reactive({});
	return {
		modules,
	};
});
