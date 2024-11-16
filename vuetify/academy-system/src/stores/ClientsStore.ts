import { defineStore } from "pinia";
import { ref, reactive } from "vue"
export const useClientsStore = defineStore('clients', () => {
  const isOpenCreateModal = ref(false)
  const formStep = ref(0)
  const formSteps = reactive({
    student: {},
    address: {},
    register: {},
  })
  function openCreateModal() {
    isOpenCreateModal.value = true;
  }
  function closeCreateModal() {
    isOpenCreateModal.value = false;
    formStep.value = 0
  }
  async function nextStep() {
    formStep.value++
  }
  function prevStep() {
    formStep.value--
  }
  function setStep(id: number) {
    formStep.value = id
  }
  return {
    isOpenCreateModal,
    formStep,
    openCreateModal,
    closeCreateModal,
    nextStep,
    prevStep,
    setStep,
    formSteps
  }
});
