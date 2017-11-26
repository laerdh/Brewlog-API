package com.ledahl.brewlog.model

data class User(val id: Int,
                val firstName: String,
                val lastName: String,
                val initials: String?,
                val email: String)