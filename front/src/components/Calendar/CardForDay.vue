<template>
  <v-card
    class="pa-2"
    max-width="250"
    height="175"
    width="150%"
    tile
    outlined
    @click="startRegistration"
  >
    <div style="text-align: center;">
      {{ day }}
    </div>
    <div style="text-align: center;">
      {{ date[2] }}
    </div>
    <v-alert
      dense
      v-for="schedule in currentDateSchedules"
      :key="schedule.title"
      color="#2196f3"
      height="20%"
    >
      <span style="font-size: small;">
        {{ schedule.title }}
      </span>
    </v-alert>
  </v-card>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator'
import { CalendarModule } from '@/store/modules/calendar'

@Component
export default class CardForDay extends Vue {
  @Prop()
  public date!: number[]

  @Prop()
  public day!: string

  @Emit()
  startRegistration() {
    return this.date[2]
  }

  private get currentDateSchedules() {
    return CalendarModule.schedules.filter(
      schedule =>
        schedule.dateStart[0] === this.date[0] &&
        schedule.dateStart[1] === this.date[1] &&
        schedule.dateStart[2] === this.date[2]
    )
  }
}
</script>
