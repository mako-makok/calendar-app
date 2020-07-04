<template>
  <div>
    {{ `${getDate().getFullYear()}年${getDate().getMonth() + 1}月` }}
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import { CalendarModule } from '@/store/modules/calendar'

@Component
export default class TextYearAndMonth extends Vue {
  getDate() {
    return CalendarModule.currentDate
  }
}
</script>
