package com.ledahl.brewlog.dto

data class FeedDto(val current: BeerDto?,
                   val available: List<BeerDto?>)