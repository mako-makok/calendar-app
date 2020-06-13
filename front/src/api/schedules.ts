import request from '@/util/request'

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

export const getSchedule = () => {
  return request({
    url: 'calendar',
    method: METHOD.GET
  })
}

export interface ScheduleParam {
  title: string
  description: string
  dateStart: Date
  dateEnd: Date
}
