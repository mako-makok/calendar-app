import { Mutation, Action, VuexModule, getModule, Module } from 'vuex-module-decorators'
import store from '@/store'
import { getSchedule } from '@/api/schedules'
import { CalendarState, Schedule } from '@/types/schedule.type'

@Module({ dynamic: true, store, name: 'calendar', namespaced: true })
class Calendar extends VuexModule implements CalendarState {
  public currentDate = new Date()
  public schedules: Schedule[] = []

  @Action
  public incrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1))
  }

  @Action
  public decrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1))
  }

  @Action({ rawError: true })
  public async getAllSchedule() {
    await getSchedule().then(res => {
      this.SET_SCHEDULES(res.data.schedules)
    })
  }

  @Mutation
  private SET_DATE(date: Date) {
    this.currentDate = date
  }

  @Mutation
  private SET_SCHEDULES(schedules: Schedule[]) {
    this.schedules = schedules
  }
}

export const CalendarModule = getModule(Calendar)
