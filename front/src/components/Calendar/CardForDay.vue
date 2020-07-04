<template>
  <v-dialog v-model="dialog" max-width="600px">
    <template #activator="{ on }">
      <v-card class="pa-2" max-width="250" height="175" width="150%" tile outlined>
        <div style="text-align: center;">
          {{ day }}
        </div>
        <div style="text-align: center;">
          {{ date[2] }}
        </div>
        <div
          v-for="schedule in currentDateSchedules"
          :key="schedule.title"
          v-on="on"
          @click="updateClickedSchedule(schedule)"
        >
          <v-alert dense color="#2196f3" height="20%">
            <span style="font-size: small;">
              {{ schedule.title }}
            </span>
          </v-alert>
        </div>
      </v-card>
    </template>
    <FormSchedule :date="date" :propSchedule="schedule" @clicked-register="register" />
  </v-dialog>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator'
import { CalendarModule } from '@/store/modules/calendar'
import FormSchedule from '@/components/Calendar/AddSchedule/FormSchedule.vue'
import { Schedule } from '@/types/schedule.type'

@Component({
  components: {
    FormSchedule
  }
})
export default class CardForDay extends Vue {
  @Prop() public date!: number[]
  @Prop() public day!: string
  private dialog = false
  private schedule: Schedule = { title: '', description: '', dateStart: [], dateEnd: [] }

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

  private updateClickedSchedule(schedule: Schedule) {
    this.schedule = schedule
  }
}
</script>
