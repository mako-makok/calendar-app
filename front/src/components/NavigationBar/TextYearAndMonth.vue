<template>
  <div>
    {{ `${getDate().getFullYear()}年${getDate().getMonth() + 1}月` }}
  </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import { ScheduleModule } from '@/store/modules/schedule'

@Component
export default class TextYearAndMonth extends Vue {
  getDate() {
    return ScheduleModule.currentDate
  } 
}
</script>
