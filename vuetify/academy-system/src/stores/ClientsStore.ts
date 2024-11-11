import { defineStore } from "pinia";

export const useClientsStore = defineStore('clients', {
  state() {
    return {
      isOpenCreateModal: false
    }
  },
  actions: {
    openCreateModal() {
      this.isOpenCreateModal = true;
    },
    closeCreateModal() {
      this.isOpenCreateModal = false;
    }
  },
  getters: {
  }
});
