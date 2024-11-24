<template>
  <v-card-tex class="d-flex flex-column ga-4">
    <div class="d-flex">
      <v-col class="fill-width pa-0 ma-0 h-auto">
        <v-text-field variant="outlined" density="compact" :label="$t('name')" hide-details="auto" class="mb-4"
          :prepend-inner-icon="Smile" v-model="localForm.firstName"
          :rules="[rules.required, (it: string) => !(it.length >= 80) || $t('field-must-have-a-maximum', { count: 80 })]" />
        <v-text-field variant="outlined" density="compact" :label="$t('last-name')" hide-details="auto"
          :prepend-inner-icon="Smile" v-model="localForm.lastName"
          :rules="[rules.required, (it: string) => !(it.length >= 80) || $t('field-must-have-a-maximum', { count: 80 })]" />
      </v-col>
      <InputImageFile class="ml-4" :onLoadFile="(it: File) => { localForm.avatar = it }" />
    </div>
    <div class="fill-width d-flex ga-4">
      <v-text-field variant="outlined" density="compact" :label="$t('cpf')" hide-details="auto"
        :prepend-inner-icon="IdCard" v-mask="'###.###.###-##'" v-model="localForm.cpf" :max="11"
        :rules="[rules.required, it => z.string().min(11).safeParse(it).success || $t('field-must-have-a-minimum', { count: 11 })]" />
      <v-text-field variant="outlined" density="compact" :label="$t('birthday')" hide-details="auto"
        :prepend-inner-icon="Cake" type="date" style="max-width: 220px;" v-model="localForm.birthday"
        :rules="[rules.required]" />
    </div>
    <v-autocomplete variant="outlined" density="compact" :label="$t('gender')" hide-details="auto"
      :prepend-inner-icon="Blend" type="gender" :placeholder="$t('enger')" v-model="localForm.gender" ref="gender"
      :items="genders"></v-autocomplete>
    <v-text-field variant="outlined" density="compact" :label="$t('e-mail')" hide-details="auto"
      :prepend-inner-icon="Mail" type="email" :placeholder="$t('example-mail')" v-model="localForm.mail"
      :rules="[it => z.string().email().safeParse(it).success || $t('invalid-email')]" />
    <v-text-field variant="outlined" density="compact" :label="$t('phone')" hide-details="auto"
      :prepend-inner-icon="Phone" v-mask="'(##) # ####-####'" v-model="localForm.phone" />
    <v-text-field variant="outlined" density="compact" :label="$t('whatsapp')" hide-details="auto"
      :prepend-inner-icon="MessageCircle" v-mask="'(##) # ####-####'" v-model="localForm.whatsapp" />
    <v-checkbox :label="$t('use-the-phone-as-a-whatsapp-number')" hide-details density="compact"
      v-model="onCheckUsePhone" />
  </v-card-tex>
</template>

<script lang="ts" setup>
import InputImageFile from "@/components/fields/InputImageFile.vue"
import { MessageCircle, Smile, Mail, IdCard, Phone, Cake, Blend } from "lucide-vue-next"
import { ref, computed, defineProps } from "vue"
import { useI18n } from "vue-i18n"
import { z } from "zod";
const { t } = useI18n()
const genders = ref([
  {
    title: t('male'),
    value: 'male',
  },
  {
    title: t('female'),
    value: 'female',
  },
  {
    title: t('other'),
    value: 'other',
  },

])
const props = defineProps(["form"])
const localForm = computed(() => props.form)
const rules = {
  required: (it: string) => !!it || t('required-field')
}
const onCheckUsePhone = computed({
  get() {
    return localForm.value.whatsapp === localForm.value.phone && !!localForm.value.phone;
  },
  set(value: boolean) {
    if (value) {
      localForm.value.whatsapp = localForm.value.phone;
    }
    else {
      localForm.value.whatsapp = "";
    }
  }
})
</script>
<style></style>
