package com.calendar.service

import com.calendar.dao.ScheduleDao
import com.calendar.entity.Schedule
import com.calendar.exception.RecordNotFoundException
import org.seasar.doma.jdbc.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ScheduleService {

    @Autowired
    lateinit var scheduleDao: ScheduleDao

    fun insert (entity: Schedule): Result<Schedule>
            = scheduleDao.insert(entity)

    fun selectAll(): List<Schedule>
            = scheduleDao.findAll()

    fun findById(id: Int): Schedule
            = scheduleDao.findById(id) ?: throw RecordNotFoundException()

    fun update(entity: Schedule): Result<Schedule>
            = scheduleDao.update(entity)

    fun deleteById(id: Int): Int
            = scheduleDao.deleteById(id)
}