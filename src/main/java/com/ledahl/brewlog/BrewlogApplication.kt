package com.ledahl.brewlog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BrewlogApplication

fun main(args: Array<String>) {
    SpringApplication.run(BrewlogApplication::class.java, *args)
}