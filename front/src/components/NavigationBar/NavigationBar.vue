<template>
  <div>
    <v-app-bar
      dense
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title>Calendar</v-toolbar-title>
    </v-app-bar>
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'

@Component
export default class NavigationBar extends Vue {}
</script>