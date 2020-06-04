package com.calendar.entity

import org.seasar.doma.*
import org.seasar.doma.jdbc.entity.NamingType
import java.time.LocalDate

@Entity(immutable = true, naming = NamingType.LENIENT_SNAKE_LOWER_CASE)
@Table(name = "schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val userId: Int,
    val title: String,
    val description: String,
    val dateStart: LocalDate,
    val dateEnd: LocalDate
)