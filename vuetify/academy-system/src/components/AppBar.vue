<template>
  <div class="align-center d-flex fill-widht">
    <v-avatar :size="40" color="rgb(var(--v-theme-surface))" class="mr-2">
      <v-img v-if="urlCompanyPhoto" :src="urlCompanyPhoto" />
      <Image v-else />
    </v-avatar>
    <v-avatar :size="40" color="rgb(var(--v-theme-surface))">
      <v-img v-if="urlCompanySystem" :src="urlCompanySystem" />
      <Image v-else />
    </v-avatar>
    <v-spacer />
    <v-list-item class="text-right" lines="two" :append-avatar="user.urlAvatar" :subtitle="user.profile"
      :title="user.name"></v-list-item>
    <v-btn icon :size="40">
      <log-out />
    </v-btn>
  </div>
</template>

<script>
import { Image, LogOut } from "lucide-vue-next"

export default {
  components: {
    Image,
    LogOut
  },
  data() {
    return {
      urlCompanyPhoto: "",
      urlCompanySystem: "",
      user: {
        name: "User Name",
        profile: "Profile",
        urlAvatar: "https://www.github.com/francivaldo4334.png"
      }
    }
  }
}
</script>

<style></style>
