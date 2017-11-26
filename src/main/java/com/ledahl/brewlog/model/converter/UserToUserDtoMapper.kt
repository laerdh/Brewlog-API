package com.ledahl.brewlog.model.converter

import com.ledahl.brewlog.dto.UserDto
import com.ledahl.brewlog.model.User
import org.springframework.stereotype.Component

@Component
class UserToUserDtoMapper : Mapper<User, UserDto>() {

    override fun map(v: User?): UserDto? {
        val u: User = v?.let { it } ?: return null

        return UserDto(
                u.id,
                u.firstName,
                u.lastName,
                u.initials,
                u.email
        )
    }

    override fun map(v: List<User>?): List<UserDto?> {
        val u: List<User> = v?.takeIf { it.isNotEmpty() } ?: return listOf()

        return u.map { map(it) }
    }

}