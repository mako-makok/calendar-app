import Vue from 'vue'
import Vuex from 'vuex'
import { CalendarState } from '@/types/schedule.type'

Vue.use(Vuex)

export interface RootState {
  calendar: CalendarState
}

export default new Vuex.Store<RootState>({})
