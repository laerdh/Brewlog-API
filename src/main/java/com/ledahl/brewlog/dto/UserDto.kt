package com.ledahl.brewlog.dto

data class UserDto(val id: Int,
                   val firstName: String,
                   val lastName: String,
                   val initials: String?,
                   val email: String)