import request from '@/util/request'
import { Schedules } from '@/types/schedule.type'
import { AxiosPromise } from 'axios'

enum METHOD {
  GET = 'get',
  POST = 'post',
  PUT = 'put',
  DELETE = 'delete'
}

export const registSchedule = (params: any) => {
  return request({
    url: 'calendar/register',
    method: METHOD.POST,
    params
  })
}

export const getSchedule = () =>
  request({
    url: 'calendar',
    method: METHOD.GET
  }) as AxiosPromise<Schedules>

export interface ScheduleParam {
  title: string
  description: string
  dateStart: Date
  dateEnd: Date
}
