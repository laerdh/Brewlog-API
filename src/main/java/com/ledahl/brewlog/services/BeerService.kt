package com.ledahl.brewlog.services

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.model.Beer
import com.ledahl.brewlog.model.converter.Mapper
import com.ledahl.brewlog.repository.BeerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

interface BeerService {
    fun getBeers() : List<BeerDto?>
    fun getBeer(id: Long) : BeerDto?
    fun insertBeer(b: BeerDto) : Long?
    fun updateCurrentSelected(volumeConsumed: Double) : BeerDto?
}

@Service
class BeerServiceImpl : BeerService {

    @Autowired
    lateinit var beerRepository: BeerRepository

    @Autowired
    lateinit var mapper: Mapper<Beer, BeerDto>

    override fun getBeers() : List<BeerDto?> {
        return mapper.map(beerRepository.getBeers())
    }

    override fun getBeer(id: Long): BeerDto? {
        try {
            return mapper.map(beerRepository.getBeer(id))
        } catch (e: EmptyResultDataAccessException) {
            // Not necessary to log
        }

        return null
    }

    override fun insertBeer(b: BeerDto): Long? {
        return beerRepository.insertBeer(b)
    }

    override fun updateCurrentSelected(volumeConsumed: Double) : BeerDto? {
        val beer: Beer = beerRepository.getCurrentSelectedBeer()?.let { it } ?: return null
        val remainingVolume = beer.volumeRemaining - volumeConsumed

        if (remainingVolume < 0) {
            return null
        }

        if (beerRepository.updateVolume(beer.batchNumber, remainingVolume) > 0) {
            return mapper.map(beerRepository.getBeer(beer.batchNumber))
        }
        return null
    }
}