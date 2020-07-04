export interface CalendarState {
  currentDate: Date
  schedules: Schedule[]
}

export interface Schedules {
  schedules : Schedule[]
}

export interface Schedule {
  title: string
  description: string
  dateStart: number[]
  dateEnd: number[]
}