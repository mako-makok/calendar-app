package com.calendar.dao;

import com.calendar.entity.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface UserDao {

    @Select
    List<User> selectAll();
}
