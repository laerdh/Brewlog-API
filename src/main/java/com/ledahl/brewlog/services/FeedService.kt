package com.ledahl.brewlog.services

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.dto.FeedDto
import com.ledahl.brewlog.model.Beer
import com.ledahl.brewlog.model.converter.BeerToBeerDtoMapper
import com.ledahl.brewlog.repository.BeerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface FeedService {
    fun getFeed(): FeedDto
}

@Service
class FeedServiceImpl : FeedService {

    @Autowired
    lateinit var beerRepository: BeerRepository

    @Autowired
    lateinit var mapper: BeerToBeerDtoMapper

    override fun getFeed(): FeedDto {
        val all: List<Beer> = beerRepository.getAvailableBeers()
        if (all.isEmpty()) {
            return FeedDto(null, emptyList())
        }

        val selected: BeerDto? = mapper.map(all.first())
        val available: List<BeerDto?> = all.filter { !it.isSelected }.map { mapper.map(it) }

        return FeedDto(
                selected,
                available
        )
    }
}