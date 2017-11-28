package com.ledahl.brewlog.model

import java.util.*

data class Beer(val batchNumber: Long,
                val name: String,
                val type: String,
                val size: Double,
                val volumeRemaining: Double,
                val originalGravity: Double,
                val finalGravity: Double?,
                val alcohol: Double?,
                val date: Date,
                val brewer: String,
                val comment: String?,
                val isSelected: Boolean)