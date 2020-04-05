package com.calendar.controller.param

import java.util.Date

data class ScheduleParam(
    val title: String,
    val description: String,
    val dateStart: Date,
    val dateEnd: Date
)