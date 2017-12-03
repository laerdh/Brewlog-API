package com.ledahl.brewlog.dto

data class BeerDto(val batchNumber: Long,
                   val name: String,
                   val type: String,
                   val size: Double,
                   val volumeRemaining: Double,
                   val alcohol: Double?,
                   val date: String,
                   val brewer: String,
                   val comment: String?)