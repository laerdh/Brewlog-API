package com.ledahl.brewlog.resources

import com.ledahl.brewlog.dto.BeerDto
import com.ledahl.brewlog.services.BeerService
import com.ledahl.brewlog.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/beer")
class BeerResource(val beerService: BeerService) {

    @Autowired
    lateinit var template: SimpMessagingTemplate

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getBeers() = beerService.getBeers()

    @RequestMapping(path = arrayOf("/{batch_number}"), method = arrayOf(RequestMethod.GET))
    fun getBeer(@PathVariable("batch_number") id: Int?): ResponseEntity<BeerDto> {
        val actualId: Int = id?.let { it } ?: return response(409)
        val beer: BeerDto = beerService.getBeer(actualId.toLong())?.let { it } ?: return response(200)
        
        return ResponseEntity.ok(beer)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun createBeer(@RequestBody beer: BeerDto): ResponseEntity<Long> {
        val id: Long? = beerService.insertBeer(beer)
        val actualId = id ?: return ResponseEntity.status(500).build()

        return ResponseEntity.created(URI.create("/beer/" + actualId.toString())).build()
    }

    @RequestMapping(path = arrayOf("/current/consume"), method = arrayOf(RequestMethod.POST))
    fun updateVolumeOnCurrentSelected(@RequestParam("volume") volumeConsumed: Double?) : ResponseEntity<BeerDto> {
        val volume = volumeConsumed?.let { it } ?: return response(409)
        val updatedBeer = beerService.updateVolumeConsumed(volume)?.let { it } ?: return response(409)

        template.convertAndSend(Constants.KEG_LEVEL_SUBSCRIBER_URI, updatedBeer)

        return ResponseEntity.ok(updatedBeer)
    }

    @RequestMapping(path = arrayOf("/current"), method = arrayOf(RequestMethod.POST))
    fun updateCurrentSelected(@RequestParam("batch_number") id: Long?) : Boolean {
        val actualId: Long = id?.let { it } ?: return false
        return beerService.updateCurrentSelected(actualId)
    }

    private fun response(status: Int): ResponseEntity<BeerDto> = ResponseEntity.status(status).build()
}