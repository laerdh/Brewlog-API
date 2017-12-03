package com.ledahl.brewlog.resources

import com.ledahl.brewlog.dto.FeedDto
import com.ledahl.brewlog.services.FeedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/feed")
class FeedResource {

    @Autowired
    lateinit var feedService: FeedService

    @CrossOrigin(origins = arrayOf("*"))
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getFeed(): FeedDto {
        return feedService.getFeed()
    }
}