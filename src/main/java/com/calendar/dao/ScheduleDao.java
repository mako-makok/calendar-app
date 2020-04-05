package com.calendar.dao;

import com.calendar.entity.Schedule;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

@ConfigAutowireable
@Dao
public interface ScheduleDao {

    @Insert
    Result<Schedule> insert(Schedule entity);

    @Select
    List<Schedule> findAll();

    @Select
    Schedule findById(int id);

    @Update
    Result<Schedule> update(Schedule entity);

    @Delete(sqlFile = true)
    int deleteById(int id);
}
