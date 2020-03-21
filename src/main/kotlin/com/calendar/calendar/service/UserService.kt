package com.calendar.calendar.service

import com.calendar.calendar.entity.User
import com.calendar.calendar.repository.UserDao
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