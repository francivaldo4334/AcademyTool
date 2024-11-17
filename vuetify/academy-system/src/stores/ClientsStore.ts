import { defineStore } from "pinia";
import { ref, reactive } from "vue";
interface StudentForm {
	firstName: string;
	lastName: string;
	avatar?: File;
	cpf: string;
	birthday?: Date;
	gender: string;
	mail: string;
	phone: string;
	whatsapp: string;
	usePhone: boolean;
	//
	addressString: string;
	city: string;
	neighborhood: string;
	street: string;
	zipCode: string;
	addressNumber: string;
	reference: string;
	//
	startDate?: Date;
	endDate?: Date;
	modality: string;
	observation: string;
}
export const useClientsStore = defineStore("clients", () => {
	const isOpenCreateModal = ref(false);
	const formStep = ref(0);
	const initForm: StudentForm = {
		firstName: "",
		lastName: "",
		avatar: undefined,
		cpf: "",
		birthday: undefined,
		gender: "",
		mail: "",
		phone: "",
		whatsapp: "",
		usePhone: false,
		//
		addressString: "",
		city: "",
		neighborhood: "",
		street: "",
		zipCode: "",
		addressNumber: "",
		reference: "",
		//
		startDate: undefined,
		endDate: undefined,
		modality: "",
		observation: "",
	};
	const form = reactive(initForm);
	function openCreateModal() {
		isOpenCreateModal.value = true;
	}
	function closeCreateModal() {
		isOpenCreateModal.value = false;
		formStep.value = 0;
	}
	async function nextStep() {
		formStep.value++;
	}
	function prevStep() {
		formStep.value--;
	}
	function setStep(id: number) {
		formStep.value = id;
	}
	return {
		isOpenCreateModal,
		formStep,
		openCreateModal,
		closeCreateModal,
		nextStep,
		prevStep,
		setStep,
		form,
	};
});
