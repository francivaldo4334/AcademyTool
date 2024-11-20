<template>
  <v-dialog width="600px" persistent>
    <v-card>
      <v-card-title class="text-h6 font-weight-bold font-weight-regular justify-space-between d-flex mt-4">
        Teste
      </v-card-title>
      <v-form ref="form">
        <v-card variant="outlined" class="ma-2 pa-3" color="surface-light">
        </v-card>
        <v-divider />
        <v-card-actions>
          <v-btn variant="tonal" color="red-lighten-1" :text="$t('cancel')" @click="state.closeCreateModal"></v-btn>
          <v-btn color="primary" variant="tonal" :text="$t('save')" @click="onSubmit"></v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-dialog>
</template>
