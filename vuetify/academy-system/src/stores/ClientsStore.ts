import { defineStore } from "pinia";

export const useClientsStore = defineStore('clients', {
  state: () => ({ isOpenModalCreate: false }),
  actions: {
    openModalCreate() {
      this.isOpenModalCreate = true
    },
    closeModalCreate() {

    }
  }
});
