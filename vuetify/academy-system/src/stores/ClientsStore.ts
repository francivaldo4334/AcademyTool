import { defineStore } from "pinia";
import { ref, reactive, inject, onMounted } from "vue";
import Domain from "@/composables/domain/Domain";
import StudentModel from "@/composables/domain/models/StudentModel";

export const useClientsStore = defineStore("clients", () => {
	const isOpenCreateModal = ref(false);
	const formStep = ref(0);
	const form: StudentModel = reactive({} as StudentModel);
	const students: StudentModel[] = reactive([]);
	const domain = inject("db") as Domain;

	onMounted(() => {
		if (!domain) {
			console.error("Domain not provided via inject!");
			return;
		}
		domain.users.geAll((it: any[]) => {
			students.splice(0, students.length, ...it);
		});
	});

	function setDefautForm() {
		form.firstName = "";
		form.lastName = "";
		form.avatar = undefined;
		form.cpf = "";
		form.birthday = undefined;
		form.gender = "";
		form.mail = "";
		form.phone = "";
		form.whatsapp = "";
		form.usePhone = false;
		//
		form.addressString = "";
		form.city = "";
		form.neighborhood = "";
		form.street = "";
		form.zipCode = "";
		form.addressNumber = "";
		form.reference = "";
		//
		form.startDate = new Date();
		form.endDate = undefined;
		form.modality = 0;
		form.observation = "";
		form.isMonthlyPlan = true;
	}
	function openCreateModal() {
		isOpenCreateModal.value = true;
		setDefautForm();
	}
	function closeCreateModal() {
		isOpenCreateModal.value = false;
		formStep.value = 0;
		setDefautForm();
	}
	function onCreateStudent() {
		domain.users.add(form, (it) => {
			students.push(it);
			closeCreateModal();
		});
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
		onCreateStudent,
		students,
		form,
	};
});
