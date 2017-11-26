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
    fun updateVolume(batchNumber: Long, amountUsed: Double) : Boolean
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

    override fun updateVolume(batchNumber: Long, amountUsed: Double) : Boolean {
        val b: Beer = beerRepository.getBeer(batchNumber)?.let { it } ?: return false
        val remainingVolume = b.volumeRemaining - amountUsed

        if (remainingVolume < 0) {
            return false
        }

        if (beerRepository.updateVolume(batchNumber, remainingVolume) > 0) {
            return true
        }
        return false
    }
}