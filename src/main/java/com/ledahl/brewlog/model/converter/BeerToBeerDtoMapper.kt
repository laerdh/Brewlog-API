package com.ledahl.brewlog.model.converter

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.model.Beer
import org.springframework.stereotype.Component

@Component
class BeerToBeerDtoMapper : Mapper<Beer, BeerDto>() {

    override fun map(v: Beer?): BeerDto? {
        val b: Beer = v?.let { it } ?: return null

        return BeerDto(
                b.batchNumber,
                b.name,
                b.type,
                b.size,
                b.volumeRemaining,
                b.alcohol,
                b.date,
                b.brewer,
                b.comment
        )
    }

    override fun map(v: List<Beer>?): List<BeerDto?> {
        val b: List<Beer> = v?.takeIf { it.isNotEmpty() } ?: return listOf()

        return b.map { map(it) }
    }
}