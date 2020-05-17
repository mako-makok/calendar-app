<template>
  <v-card
    class="pa-2"
    max-width="250"
    height="175"
    width="150%"
    tile
    outlined>
    <div style="text-align: center;">hoge</div>
</v-card>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'

@Component
export default class CardForDay extends Vue {}
</script>