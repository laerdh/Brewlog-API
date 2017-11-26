package com.ledahl.brewlog.repository.mapper

import com.ledahl.brewlog.model.User
import com.ledahl.brewlog.repository.UserProperties
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserRowMapper : RowMapper<User> {

    override fun mapRow(p0: ResultSet?, p1: Int): User? {
        val rs = p0?.let { it } ?: return null

        return User(
                rs.getInt(UserProperties.PRIMARY_KEY),
                rs.getString(UserProperties.FIRST_NAME),
                rs.getString(UserProperties.LAST_NAME),
                rs.getString(UserProperties.INITIALS),
                rs.getString(UserProperties.EMAIL).toLowerCase()
        )
    }
}