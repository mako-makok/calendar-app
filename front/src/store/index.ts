import Vue from 'vue'
import Vuex from 'vuex'
import { ScheduleState } from './modules/schedule'

Vue.use(Vuex)

export interface RootState {
  schedule: ScheduleState
}

export default new Vuex.Store<RootState>({})
