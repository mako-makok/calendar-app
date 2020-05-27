<template>
  <v-container>
    <template v-for="i in dispDates.length / 7">
      <v-row no-gutters :key="i">
        <template v-for="j in 7">
          <v-col :key="j">
            <CardForDay :date="dispDates[((i - 1) * 7 + j) - 1]" />
          </v-col>
        </template>
      </v-row>
    </template>
  </v-container>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import CardForDay from '@/components/Calendar/CardForDay.vue'
import { ScheduleModule } from '@/store/modules/schedule'

@Component({
  components: {
    CardForDay
  }
})
export default class CalendarBoard extends Vue {
  get dispDates(): number[] {
    const currentDate = ScheduleModule.currentDate

    const beginOfMonth = new Date(
      currentDate.getFullYear(),
      currentDate.getMonth(),
      1
    )
    const day = beginOfMonth.getDay()
    const dates: number[] = []

    // 月初が月曜日の場合は、先月分の日付を取得しない
    if (day > 1) {
      const endOfLastMonth = new Date(
        currentDate.getFullYear(),
        currentDate.getMonth(),
        0
      )
      for (let i = endOfLastMonth.getDay() - 1; i >= 0; i--) {
        dates.push(endOfLastMonth.getDate() - i)
      }
    }

    // 月初が日曜の場合は先月の月曜から土曜を加える
    if (day === 0) {
      const endOfLastMonthForDate = new Date(
        currentDate.getFullYear(),
        currentDate.getMonth(),
        0
      ).getDate()
      for (let i = endOfLastMonthForDate - 5; i <= endOfLastMonthForDate; i++) {
        dates.push(i)
      }
    }

    const endOfMonth = new Date(
      currentDate.getFullYear(),
      currentDate.getMonth() + 1,
      0
    )
    for (let i = beginOfMonth.getDate(); i <= endOfMonth.getDate(); i++) {
      dates.push(i)
    }

    // 月末が日曜終わりではない場合は来月の日曜日までの日付を取得する
    if (endOfMonth.getDay() !== 0) {
      for (let i = 1; i <= 7 - endOfMonth.getDay(); i++) {
        dates.push(i)
      }
    }

    return dates
  }
}
</script>
