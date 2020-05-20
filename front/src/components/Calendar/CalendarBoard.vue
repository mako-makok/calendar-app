<template>
  <v-container>
    <template v-for="i in 5">
      <v-row no-gutters :key="i">
        <template v-for="n in 7">
          <v-col :key="n">
            <CardForDay />
          </v-col>
        </template>
      </v-row>
    </template>
  </v-container>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import CardForDay from '@/components/Calendar/CardForDay.vue'

@Component({
  components: {
    CardForDay
  }
})
export default class CalendarBoard extends Vue {}
</script>