package com.calendar.controller

import com.calendar.controller.param.ScheduleParam
import com.calendar.entity.Schedule
import com.calendar.service.ScheduleService
import org.seasar.doma.jdbc.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("calendar")
class CalendarController {

    @Autowired
    lateinit var scheduleService: ScheduleService

    @GetMapping
    fun index(): Map<String, List<Schedule>>
            = mapOf("schedules" to scheduleService.selectAll())

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody @Validated scheduleParam: ScheduleParam): Result<Schedule> {
        val entity = Schedule(
                userId = 1,
                title = scheduleParam.title,
                description = scheduleParam.description,
                dateStart = LocalDate.now(),
                dateEnd = LocalDate.now()
        )

        return scheduleService.insert(entity)
    }

    @PostMapping("detail/{id}")
    fun detail(@PathVariable id: Int): Map<String, Schedule>
            = mapOf("schedule" to scheduleService.findById(id))

    @PutMapping("update/{id}")
    fun update(
            @PathVariable id: Int,
            @RequestBody @Validated scheduleParam: ScheduleParam): Result<Schedule> {
        val entity = Schedule(
                id = id,
                userId = 1,
                title = scheduleParam.title,
                description = scheduleParam.description,
                dateStart = scheduleParam.dateStart,
                dateEnd = scheduleParam.dateEnd
        )

        return scheduleService.update(entity)
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Int): Int
            = scheduleService.deleteById(id)
}