package com.calendar.service

import com.calendar.dao.UserDao
import com.calendar.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    fun selectAll(): List<User> {
        return userDao.selectAll()
    }
}