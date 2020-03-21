package com.calendar.calendar.repository

import com.calendar.calendar.entity.Schedule
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@ConfigAutowireable
@Dao
interface ScheduleDao {

    @Select
    fun selectAll(): List<Schedule>
}