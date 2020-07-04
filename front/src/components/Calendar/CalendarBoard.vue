<template>
  <div>
    <v-container>
      <template v-for="i in dispDates.length / 7">
        <v-row no-gutters :key="i">
          <template v-for="j in 7">
            <v-col :key="j">
              <CardForDay
                :date="dispDates[(i - 1) * 7 + j - 1]"
                :day="days[j - 1]"
                @start-registration="openDialog($event)"
              />
            </v-col>
          </template>
        </v-row>
      </template>
    </v-container>
    <DialogRegisterSchedule ref="dialogRegisterSchedule" />
  </div>
</template>

<script lang="ts">
import { Vue, Component, Ref } from 'vue-property-decorator'
import CardForDay from '@/components/Calendar/CardForDay.vue'
import DialogRegisterSchedule from '@/components/AddSchedule/DialogRegisterSchedule.vue'
import { CalendarModule } from '@/store/modules/calendar'

@Component({
  components: {
    CardForDay,
    DialogRegisterSchedule
  }
})
export default class CalendarBoard extends Vue {
  private days = ['日', '月', '火', '水', '木', '金', '土']

  @Ref() dialogRegisterSchedule!: DialogRegisterSchedule

  private openDialog(date: number) {
    this.dialogRegisterSchedule.open(
      CalendarModule.currentDate.getFullYear(),
      CalendarModule.currentDate.getMonth(),
      date
    )
  }

  get dispDates(): number[][] {
    const currentDate = CalendarModule.currentDate

    const beginOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1)
    const dates: number[][] = []
    const endOfLastMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 0)

    // 月初が月曜日、日曜日以外の場合は、先月分の日付を取得する
    const day = beginOfMonth.getDay()
    if (day > 1) {
      for (let i = endOfLastMonth.getDay() - 1; i >= 0; i--) {
        dates.push([
          endOfLastMonth.getFullYear(),
          endOfLastMonth.getMonth() + 1,
          endOfLastMonth.getDate() - i
        ])
      }
    }
    // 月初が日曜の場合は先月の月曜から土曜を加える
    if (day === 0) {
      const date = endOfLastMonth.getDate()
      for (let i = date - 5; i <= date; i++) {
        dates.push([endOfLastMonth.getFullYear() + 1, endOfLastMonth.getMonth() + 1, i])
      }
    }

    const endOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0)
    for (let i = beginOfMonth.getDate(); i <= endOfMonth.getDate(); i++) {
      dates.push([beginOfMonth.getFullYear(), beginOfMonth.getMonth() + 1, i])
    }

    // 月末が日曜終わりではない場合は来月の日曜日までの日付を取得する
    if (endOfMonth.getDay() !== 0) {
      for (let i = 1; i <= 7 - endOfMonth.getDay(); i++) {
        dates.push([beginOfMonth.getFullYear(), beginOfMonth.getMonth() + 2, i])
      }
    }

    return dates
  }

  private created() {
    CalendarModule.getAllSchedule()
  }
}
</script>
