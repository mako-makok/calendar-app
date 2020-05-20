<template>
  <v-btn tile large color="teal" icon @click="changeMonth"> 
    <v-icon v-if="isNext">
      keyboard_arrow_right
    </v-icon>
    <v-icon v-if="!isNext">
      keyboard_arrow_left
    </v-icon>
  </v-btn>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'
import { ScheduleModule } from '@/store/modules/schedule'

@Component
export default class BtnArrowLeft extends Vue {
  @Prop()
  public isNext?: boolean;

  changeMonth() {
    this.isNext
      ? ScheduleModule.incrementMonth()
      : ScheduleModule.decrementMonth()
  }
}
</script>
