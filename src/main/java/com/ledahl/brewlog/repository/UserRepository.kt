package com.ledahl.brewlog.repository

import com.ledahl.brewlog.model.User
import com.ledahl.brewlog.repository.mapper.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getUsers() : List<User> {
        return jdbcTemplate.query(
                UserProperties.SELECT_ALL_USERS,
                UserRowMapper()
        )
    }

    fun getUserByEmail(email: String) : User? {
        val  namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)

        val parameterSource = MapSqlParameterSource()
        parameterSource.addValue(UserProperties.EMAIL, email.toLowerCase())

        return namedParameterJdbcTemplate.queryForObject(
                UserProperties.SELECT_USER_BY_EMAIL,
                parameterSource,
                UserRowMapper()
        )
    }
}