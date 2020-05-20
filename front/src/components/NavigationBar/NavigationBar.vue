<template>
  <div>
    <v-app-bar dense>
      <v-app-bar-nav-icon />
      <v-icon>calendar_today</v-icon>
      <v-toolbar-title>Calendar</v-toolbar-title>
      <BtnAllow :is-next="false" />
      <BtnAllow :is-next="true" />
      <div>
        <TextYearAndMonth />
      </div>
    </v-app-bar>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import BtnAllow from '@/components/NavigationBar/BtnArrow.vue'
import TextYearAndMonth from '@/components/NavigationBar/TextYearAndMonth.vue'

@Component({
  components: {
    BtnAllow,
    TextYearAndMonth
  }
})
export default class NavigationBar extends Vue {}
</script>
