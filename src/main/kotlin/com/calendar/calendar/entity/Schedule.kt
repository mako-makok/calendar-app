package com.calendar.calendar.entity

import org.seasar.doma.*
import org.seasar.doma.jdbc.entity.NamingType
import java.util.*

@Entity(immutable = true, naming = NamingType.LENIENT_SNAKE_LOWER_CASE)
@Table(name = "schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Integer,
    val userId: Integer,
    val title: String,
    val description: String,
    val dateStart: Date,
    val dateEnd: Date
)