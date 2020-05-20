import { Mutation, Action, VuexModule, getModule, Module } from 'vuex-module-decorators'
import store from '@/store'

export interface ScheduleState {
  currentDate: Date;
}

@Module({ dynamic: true, store, name: 'schedule' })
class Schedule extends VuexModule implements ScheduleState {
  public currentDate = new Date();

  @Mutation
  private SET_DATE(date: Date) {
    this.currentDate = date
  }

  @Action({})
  public incrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1))
  }

  @Action({})
  public decrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1))
  }
}

export const ScheduleModule = getModule(Schedule)