package com.calendar.entity

import org.seasar.doma.*
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.LENIENT_SNAKE_LOWER_CASE)
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Integer
)