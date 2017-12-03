package com.ledahl.brewlog.model

data class Beer(val batchNumber: Long,
                val name: String,
                val type: String,
                val size: Double,
                val volumeRemaining: Double,
                val originalGravity: Double,
                val finalGravity: Double?,
                val alcohol: Double?,
                val date: String,
                val brewer: String,
                val comment: String?,
                val isSelected: Boolean)