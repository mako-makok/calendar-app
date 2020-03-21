package com.calendar.calendar.controller

import com.calendar.calendar.service.ScheduleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    lateinit var scheduleService: ScheduleService

    @GetMapping("/")
    fun index(): String {
        return scheduleService.selectAll().toString()
    }
}