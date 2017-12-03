package com.ledahl.brewlog.repository

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.model.Beer
import com.ledahl.brewlog.repository.mapper.BeerRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class BeerRepository {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun getBeers() : List<Beer> {
        return jdbcTemplate.query(
                BeerProperties.SELECT_ALL_BEERS,
                BeerRowMapper()
        )
    }

    fun getAvailableBeers() : List<Beer> {
        return jdbcTemplate.query(
                BeerProperties.SELECT_ALL_AVAILABLE_BEERS,
                BeerRowMapper()
        )
    }

    fun getBeer(id: Long) : Beer? {
        val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)

        val parameterSource = MapSqlParameterSource()
        parameterSource.addValue(BeerProperties.PRIMARY_KEY, id)

        return namedParameterJdbcTemplate.queryForObject(
                BeerProperties.SELECT_BEER,
                parameterSource,
                BeerRowMapper()
        )
    }

    fun setCurrentSelected(id: Long) : Int {
        val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)

        val parameterSource = MapSqlParameterSource()
        parameterSource.addValue(BeerProperties.PRIMARY_KEY, id)

        return namedParameterJdbcTemplate.update(
                BeerProperties.SET_CURRENT_ACTIVE,
                parameterSource
        )
    }

    fun getCurrentSelected() : Beer? {
        return jdbcTemplate.queryForObject(
                BeerProperties.SELECT_CURRENT_SELECTED_BEER,
                BeerRowMapper()
        )
    }

    fun resetCurrentSelected() : Int {
        return jdbcTemplate.update(
                BeerProperties.RESET_CURRENT_ACTIVE
        )
    }

    fun insertBeer(b: BeerDto) : Long? {
        val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)

        val parameterSource = MapSqlParameterSource()
        parameterSource.addValue(BeerProperties.NAME, b.name)
        parameterSource.addValue(BeerProperties.TYPE, b.type)
        parameterSource.addValue(BeerProperties.SIZE, b.size)
        parameterSource.addValue(BeerProperties.VOLUME_REMAINING, b.volumeRemaining)
        parameterSource.addValue(BeerProperties.ORIGINAL_GRAVITY, 0.0)
        parameterSource.addValue(BeerProperties.DATE, b.date)
        parameterSource.addValue(BeerProperties.BREWER, b.brewer)
        parameterSource.addValue(BeerProperties.COMMENT, b.comment)

        return namedParameterJdbcTemplate.update(
                BeerProperties.INSERT_BEER,
                parameterSource
        ).toLong()
    }

    fun updateVolume(batchNumber: Long, remainingVolume: Double) : Int {
        val namedParameterJdbcTemplate = NamedParameterJdbcTemplate(jdbcTemplate)

        val parameterSource = MapSqlParameterSource()
        parameterSource.addValue(BeerProperties.PRIMARY_KEY, batchNumber)
        parameterSource.addValue(BeerProperties.VOLUME_REMAINING, remainingVolume)

        return namedParameterJdbcTemplate.update(
                BeerProperties.UPDATE_VOLUME_REMAINING,
                parameterSource
        )
    }
}
