package com.ledahl.brewlog.dto

import java.util.*

data class BeerDto(val batchNumber: Long,
                   val name: String,
                   val type: String,
                   val size: Double,
                   val volumeRemaining: Double,
                   val alcohol: Double?,
                   val date: Date,
                   val brewer: String,
                   val comment: String?)