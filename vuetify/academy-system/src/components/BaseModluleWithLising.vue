<template>
  <div class="w-100 h-100">
    <v-col offset="2" cols="8">
      <p class="text-h5 mb-4">{{ $t(title, 2) }}</p>
      <v-tabs v-model="menuSelected" color="primary" class="mb-4">
        <v-tab v-for="opt in menuOptions" :key="opt.key" :value="opt.key">{{ $t(opt.name, 2) }}</v-tab>
      </v-tabs>
      <v-tabs-window v-model="menuSelected">
        <v-tabs-window-item v-for="opt in menuOptions" :key="opt.key" :value="opt">
          <div class="my-2 w-100 d-flex justify-space-between align-center ga-2">
            <div class="d-flex ga-2 w-100 align-center">
              <slot v-for="(func, key) in opt.filters" :key="key" :name="key"
                :action="func(store.modules[title][opt.name].items)"></slot>
            </div>
            <v-btn icon :size="40" @click="store.modules[title][opt.name].openModalAddItem" color="primary" rounded>
              <slot name="icon-btn-add"></slot>
              <v-tooltip activator="parent" location="bottom">
                {{ $t('add-new-item', { item: $t(opt.name) }) }}
              </v-tooltip>
            </v-btn>
            <v-dialog v-model="store.modules[title][opt.name].isOpenModalAddItem" width="600px" persistent>
              <v-card>
                <v-card-title class="text-h6 font-weight-bold font-weight-regular justify-space-between d-flex">
                  <span>
                    <slot name="new-item-modal-title"></slot>
                  </span>
                </v-card-title>
                <v-form :ref="el => (formRefs[`form${title}${opt.name}`] = el as VForm)">
                  <v-card variant="outlined" class="mx-2 mb-2">
                    <slot name="new-item-modal-form" :formState="store.modules[title][opt.name].formModalAddItem"
                      :changeFormSate="($event: any) => (store.modules[title][opt.name].formModalAddItem = $event)"
                      :isValid="(action: Function) => onValidForm(action, `form${title}${opt.name}`)">
                    </slot>
                  </v-card>
                  <v-divider />
                  <v-card-actions>
                    <slot name="new-item-modal-actions" :onClose="store.modules[title][opt.name].closeModalAddItem"
                      :formState="store.modules[title][opt.name].formModalAddItem"
                      :isValid="(action: Function) => onValidForm(action, `form${title}${opt.name}`)"
                      :onSubmit="onSubmint">
                    </slot>
                  </v-card-actions>
                </v-form>
              </v-card>
            </v-dialog>
          </div>
          <v-divider />
          <v-card variant="outlined" color="surface" class="mt-2">
            <v-data-table-virtual :items="store.modules[title][opt.name].items" class="bg-background"
              :no-data-text="$t('no-data')">
            </v-data-table-virtual>
          </v-card>
        </v-tabs-window-item>
      </v-tabs-window>
    </v-col>
  </div>
</template>
<script lang="ts" setup>
import { PropType, onBeforeMount, onMounted, defineProps, ref } from "vue"
import { MenuItem } from "./BaseModluleWithLising"
import { useMainStore } from '@/stores/MainStore'
import IModelDomain from "@/composables/domain/models/IModelDomain";
import { VForm } from "vuetify/components"

const formRefs = ref<Record<string, VForm | null>>({})
const store = useMainStore()
const menuSelected = ref(0)
const props = defineProps({
  title: { type: String, required: true },
  menuOptions: {
    type: Array as PropType<MenuItem<IModelDomain>[]>,
  },
})
function onSubmint() {
  if (!props.menuOptions) return;
  const option = props.menuOptions[menuSelected.value];
  const repository = option.repository;
  const scheme = option.scheme.safeParse(store.modules[props.title][option.name].formModalAddItem)
  if (scheme.success) {
    repository.add(scheme.data, (it) => {
      store.modules[props.title][option.name].items.push(it);
      store.modules[props.title][option.name].closeModalAddItem()
    })
  }
  else {
    console.error(scheme.error)
  }
}
async function onValidForm(action: Function, refKey: string) {
  const formRef = formRefs.value[refKey]
  if (formRef == null) return;
  const { valid } = await formRef.validate()
  if (valid) {
    action()
  }
}
onBeforeMount(() => {
  store.modules[props.title] = {}
  if (props.menuOptions !== undefined) {
    const menuOptions = props.menuOptions!
    for (const it of menuOptions) {
      store.modules[props.title][it.name] = {
        isOpenModalAddItem: false,
        formModalAddItem: {},
        items: [],
        openModalAddItem() {
          store.modules[props.title][it.name].isOpenModalAddItem = true
        },
        closeModalAddItem() {
          store.modules[props.title][it.name].formModalAddItem = {}
          store.modules[props.title][it.name].isOpenModalAddItem = false
        }
      }
      formRefs.value[`form${props.title}${it.name}`] = null
    }
  }
});
onMounted(() => {
  const menuOptions = props.menuOptions!
  for (const opt of menuOptions) {
    opt.repository.geAll(it => {
      const items: any[] = store.modules[props.title][opt.name].items
      store.modules[props.title][opt.name].items.splice(0, items.length, ...it)
    })
  }
})
</script>
