package com.ledahl.brewlog.resources

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.services.BeerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/beer")
class BeerResource(val beerService: BeerService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getBeers() = beerService.getBeers()

    @RequestMapping(path = arrayOf("/{batch_number}"), method = arrayOf(RequestMethod.GET))
    fun getBeer(@PathVariable("batch_number") id: Int?): ResponseEntity<BeerDto> {
        if (id !is Int) return response(409)
        val beer: BeerDto = beerService.getBeer(id.toLong()) ?: return response(200)
        
        return ResponseEntity.ok(beer)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun createBeer(@RequestBody beer: BeerDto): ResponseEntity<Long> {
        val id: Long? = beerService.insertBeer(beer)
        val actualId = id ?: return ResponseEntity.status(500).build()

        return ResponseEntity.created(URI.create("/beer/" + actualId.toString())).build()
    }

    @RequestMapping(path = arrayOf("/{batch_number}"), method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.OK)
    fun updateBeerVolume(@PathVariable("batch_number") id: Long?,
                         @RequestParam("volume_used") volumeUsed: Double?) {
        val batch = id?.let { it } ?: return
        val volume = volumeUsed?.let { it } ?: return

        beerService.updateVolume(batch, volume)
    }

    private fun response(status: Int): ResponseEntity<BeerDto> = ResponseEntity.status(status).build()
}