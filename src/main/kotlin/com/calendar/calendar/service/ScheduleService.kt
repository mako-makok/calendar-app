package com.calendar.calendar.service

import com.calendar.calendar.entity.Schedule
import com.calendar.calendar.repository.ScheduleDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ScheduleService {

    @Autowired
    lateinit var scheduleDao: ScheduleDao

    fun selectAll(): List<Schedule> {
        return scheduleDao.selectAll()
    }
}