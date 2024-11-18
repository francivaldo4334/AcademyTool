<template>
  <v-card-tex class="d-flex flex-column ga-4">
    <div class="d-flex">
      <v-col class="fill-width pa-0 ma-0 h-auto">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="Smile" :rules="[rules.required]" v-model="store.form.firstName" />
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="Smile" :rules="[rules.required]" v-model="store.form.lastName" />
      </v-col>
      <InputImageFile class="ml-4" v-model="store.form.avatar" />
    </div>
    <v-row class="fill-width d-flex pa-0 ma-0 ga-4">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" hide-details="auto"
        :prepend-inner-icon="IdCard" placeholder="XX.XXX.XXX-XX" :rules="[rules.required, rules.cpf]"
        v-model="formattedCpf" @input="store.form.cpf" :max="11" />
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :rules="[rules.required]" :prepend-inner-icon="Cake" type="date" style="max-width: 220px;"
        v-model="store.form.birthday" />
    </v-row>
    <v-autocomplete variant="outlined" density="compact" :label="$t('gender')" hide-details="auto"
      :prepend-inner-icon="Blend" type="gender" :placeholder="$t('enger')" :rules="[]" v-model="store.form.gender"
      ref="gender" :items="genders" />
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto"
      :prepend-inner-icon="Mail" type="email" :placeholder="$t('example-mail')" :rules="[rules.email]"
      v-model="store.form.mail" />
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" placeholder="(XX) X XXXX-XXXX" :rules="[rules.phone]" v-model="store.form.phone" />
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" placeholder="(XX) X XXXX-XXXX" :rules="[rules.phone]"
      v-model="store.form.whatsapp" />
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details density="compact"
      v-model="usePhoneInWhatsapp" />
  </v-card-tex>
</template>

<script lang="ts" setup>
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, Smile, Mail, IdCard, Phone, Cake, Blend } from "lucide-vue-next"
import { ref, computed } from "vue"
import { useI18n } from "vue-i18n"
import { useClientsStore } from "@/stores/ClientsStore"

const store = useClientsStore()
const { t } = useI18n()
const rules = ref({
  required: (it: string) => !!it || t("required-field"),
  email: (value: string) => {
    const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return !value || pattern.test(value) || t("invalid-email");
  },
  phone: (value: string) => {
    const pattern = /^\(?[0-9]{1,3}\)?[-\s]?[9]?[-\s]?[0-9]{4}[-\s]?[0-9]{4}$/;
    return !value || pattern.test(value) || t("invalid-phone");
  },
  cpf: (value: string) => {
    const pattern = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/;
    if (!value || !pattern.test(value)) {
      return t("invalid-cpf");
    }
    return true;
  },
});
const genders = ref([t('male'), t('female'), t('other')])

const formattedCpf = computed({
  get() {
    if (!store.form.cpf) return "";
    return store.form.cpf
      .replace(/\D/g, "")
      .replace(/(\d{3})(\d{3})(\d{3})(\d{2})$/, "$1.$2.$3-$4");
  },
  set(value: string) {
    store.form.cpf = value.replace(/\D/g, "").slice(0, 11);
  },
});
const usePhoneInWhatsapp = computed({
  get() {
    return store.form.usePhone
  },
  set(value: boolean) {
    if (value) {
      store.form.whatsapp = store.form.phone;
    }
    store.form.usePhone = value
  }
})
</script>
<style></style>
