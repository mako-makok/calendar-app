package com.calendar.controller.param

import java.time.LocalDate

data class ScheduleParam(
    val title: String,
    val description: String,
    val dateStart: LocalDate,
    val dateEnd: LocalDate
)