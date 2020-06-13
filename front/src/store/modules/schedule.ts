import { Mutation, Action, VuexModule, getModule, Module } from 'vuex-module-decorators'
import store from '@/store'

export interface ScheduleState {
  currentDate: Date
  plans: Plan[]
}

interface Plan {
  title: string
  description: string
  startDate: Date
  endDate: Date
}

@Module({ dynamic: true, store, name: 'schedule' })
class Schedule extends VuexModule implements ScheduleState {
  public currentDate = new Date()
  public plans: Plan[] = []

  @Action({})
  public incrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1))
  }

  @Action({})
  public decrementMonth() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1))
  }

  @Action({})
  public setAllPlans() {
    this.SET_DATE(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1))
  }

  @Mutation
  private SET_DATE(date: Date) {
    this.currentDate = date
  }

  @Mutation
  private SET_PLANS(plans: Plan[]) {
    this.plans = plans
  }
}

export const ScheduleModule = getModule(Schedule)
