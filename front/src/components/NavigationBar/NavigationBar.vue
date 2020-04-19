<template>
  <div>
    <v-app-bar
      dense
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-icon>calendar_today</v-icon>
      <v-toolbar-title>Calendar</v-toolbar-title>
      <BtnAllow :isLeft=true></BtnAllow>
      <BtnAllow :isLeft=false></BtnAllow>
    </v-app-bar>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import BtnAllow from '@/components/NavigationBar/BtnArrow.vue';

@Component({
  components: {
    BtnAllow
  }
})
export default class NavigationBar extends Vue {}
</script>