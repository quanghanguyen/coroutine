package com.example.coroutine.async

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = printOne()
        val two = printTwo()
        println("Kết quả: ${one + two}")
    }
    println("Tổng thời gian $time ms")
}

suspend fun printOne(): Int {
    delay(1000L)
    return 10
}

suspend fun printTwo(): Int {
    delay(1000L)
    return 20
}