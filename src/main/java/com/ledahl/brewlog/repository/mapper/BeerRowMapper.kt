package com.ledahl.brewlog.repository.mapper

import com.ledahl.brewlog.model.Beer
import com.ledahl.brewlog.repository.BeerProperties
import com.ledahl.brewlog.repository.UserProperties
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class BeerRowMapper : RowMapper<Beer> {

    override fun mapRow(p0: ResultSet?, p1: Int): Beer? {
        val rs = p0?.let { it } ?: return null

        return Beer(
                rs.getLong(BeerProperties.PRIMARY_KEY),
                rs.getString(BeerProperties.NAME),
                rs.getString(BeerProperties.TYPE),
                rs.getDouble(BeerProperties.SIZE),
                rs.getDouble(BeerProperties.VOLUME_REMAINING),
                rs.getDouble(BeerProperties.ORIGINAL_GRAVITY),
                rs.getDouble(BeerProperties.FINAL_GRAVITY),
                rs.getDouble(BeerProperties.ALCOHOL),
                rs.getDate(BeerProperties.DATE),
                rs.getString(UserProperties.FIRST_NAME) + " " + rs.getString(UserProperties.LAST_NAME),
                rs.getString(BeerProperties.COMMENT),
                rs.getBoolean(BeerProperties.SELECTED)
        )
    }
}