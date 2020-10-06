package com.brentbusby.statwatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StatwatchApplication

fun main(args: Array<String>) {
	runApplication<StatwatchApplication>(*args)
}
