import Domain from "@/composables/domain/Domain";
import ModalityModel from "@/composables/domain/models/ModalityModel";
import { defineStore } from "pinia";
import { onMounted, inject, reactive, ref } from "vue";

export const useModalityStore = defineStore("modalities", () => {
	const modalities: ModalityModel[] = [];
	const domain = inject("db") as Domain;
	const form: ModalityModel = reactive({} as ModalityModel);
	const isOpenModalCreate = ref(false);
	onMounted(() => {
		domain.modalities.getAll((it) => {
			modalities.splice(0, modalities.length, ...it);
		});
	});
	function closeModalCreate() {
		isOpenModalCreate.value = false;
		setDefaultForm();
	}
	function openModalCreate() {
		isOpenModalCreate.value = true;
		setDefaultForm();
	}
	function setDefaultForm() {
		form.value = 0;
		form.active = true;
		form.description = "";
		form.modalityPayment = "monthly";
	}
	return {
		modalities,
		form,
		isOpenModalCreate,
		openModalCreate,
		closeModalCreate,
	};
});
