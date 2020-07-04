<template>
  <v-dialog v-model="dialog" max-width="600px">
    <template #activator="{ on }">
      <v-card class="pa-2" max-width="250" height="175" width="150%" tile outlined v-on="on">
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
    <FormSchedule :date="date" @clicked-register="register" />
  </v-dialog>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit, Watch } from 'vue-property-decorator'
import { CalendarModule } from '@/store/modules/calendar'
import FormSchedule from '@/components/Calendar/AddSchedule/FormSchedule.vue'

@Component({
  components: {
    FormSchedule
  }
})
export default class CardForDay extends Vue {
  @Prop() public date!: number[]
  @Prop() public day!: string
  private dialog = false

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

  private register() {
    this.dialog = false
  }
}
</script>
